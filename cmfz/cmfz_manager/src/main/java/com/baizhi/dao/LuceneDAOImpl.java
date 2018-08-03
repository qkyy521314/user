package com.baizhi.dao;

import com.baizhi.entity.Article;
import com.baizhi.entity.ObjectPage;
import com.baizhi.util.LuceneUtil;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Repository;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/1/23.
 */
@Repository
public class LuceneDAOImpl implements LuceneDAO {

    public void insertindex(Article article) {
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();

        Document doc = new Document();
        doc.add(new TextField("title",article.getTitle(), Field.Store.YES));
        doc.add(new TextField("author",article.getAuthor(), Field.Store.YES));



        try {
            indexWriter.addDocument(doc);
            System.out.println("创建索引成功success");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                indexWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateindex(String keyword, Article article) {
        //获得indexWriter
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        //指定更新条件
        Term term = new Term("title",keyword);
        Document doc = new Document();

        doc.add(new TextField("title",article.getTitle(), Field.Store.YES));
        doc.add(new TextField("author",article.getAuthor(), Field.Store.YES));

        try {
            indexWriter.updateDocument(term,doc);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                indexWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteindex(String keyword) {
        //获得indexWriter
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        //指定删除条件
        Term term =new Term("title",keyword);
        try {
            indexWriter.deleteDocuments(term);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                indexWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Article> query(String keyword) {
        List<Article> articles = new ArrayList<Article>();
        Article article = new Article();
        //查询
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();

        Term term = new Term("title",keyword);
        TermQuery termQuery = new TermQuery(term);

        try {

            TopDocs topDocs = indexSearcher.search(termQuery, 10);
            System.out.println("获得总条数："+topDocs.totalHits);
            //处理查询结果
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            //iter
            for (ScoreDoc scoreDoc : scoreDocs) {
                int docId = scoreDoc.doc;
                Document document = indexSearcher.doc(docId);
                //封装实体
                article.setTitle(document.get("title"));
                article.setAuthor(document.get("author"));
                articles.add(article);
            }
            return articles;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObjectPage<Article> queryByPage(String keyword, Integer page, Integer rows) {
        ObjectPage<Article> articleObject = null;
        List<Article> articles = new ArrayList<Article>();
        Article article = new Article();
        //查询
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();

        //Term term = new Term("title",keyword);
        //TermQuery termQuery = new TermQuery(term);
        String[] fields={"title","author"};
        MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(Version.LUCENE_44, fields, new IKAnalyzer());
        Query query= null;
        try {
            query = multiFieldQueryParser.parse(keyword);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer pageStart = (page-1)*rows;
        Integer pageEnd = page*rows;

        try {

            TopDocs topDocs = indexSearcher.search(query, pageEnd);

            Integer totalcount = topDocs.totalHits;

            System.out.println("获得总条数："+topDocs.totalHits);
            //处理查询结果
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;

            for(int i = pageStart;i < scoreDocs.length; i++){
                ScoreDoc scoreDoc =scoreDocs[i];
                int docId = scoreDoc.doc;
                Document document = indexSearcher.doc(docId);
                //封装实体
                article.setTitle(document.get("title"));
                article.setAuthor(document.get("author"));
                articles.add(article);
            }
            return new ObjectPage<Article>(articles,totalcount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
