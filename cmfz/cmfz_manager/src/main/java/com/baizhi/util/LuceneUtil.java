package com.baizhi.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by DELL on 2018/1/23.
 */
public class LuceneUtil {
    private static Directory directory;
    private static IndexWriterConfig conf;
    private static Version lucene44;
    private static Analyzer analyzer;
    private static DirectoryReader indexReader;
    static {
        try {
            directory = FSDirectory.open(new File("d:\\lucene"));
            indexReader = DirectoryReader.open(directory);
            lucene44 = Version.LUCENE_44;
            analyzer = new IKAnalyzer();
            conf = new IndexWriterConfig(lucene44, analyzer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static IndexWriter getIndexWriter()  {
        IndexWriter indexWriter=null;
        try {
            indexWriter = new IndexWriter(directory,conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexWriter;
    }

    public static IndexSearcher getIndexSearcher(){
        return new IndexSearcher(indexReader);
    }
    //查看分词结果
    public static void analyzerResult(Analyzer analyzer, String text) throws IOException {

        System.out.println("当前分词器:--->" + analyzer.getClass().getName());

        TokenStream tokenStream = analyzer.tokenStream("content",
                new StringReader(text));

        tokenStream.addAttribute(CharTermAttribute.class);

        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            CharTermAttribute attribute = tokenStream
                    .getAttribute(CharTermAttribute.class);
            System.out.println(attribute.toString());
        }
        tokenStream.end();
    }
}
