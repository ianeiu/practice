package com.wm.demo.use;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.Date;

public class FileInfo {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException{
    	
            Path testPath = Paths.get("E:\\EclipseBulider\\j-util\\src\\main\\webapp\\WEB-INF\\lib\\mybatis-generator-core-1.3.2.jar");
            BasicFileAttributeView basicView = Files.
                    getFileAttributeView(testPath, BasicFileAttributeView.class);
            BasicFileAttributes basicFileAttributes = basicView.readAttributes();

            System.out.println("创建时间：" + new Date(basicFileAttributes.creationTime()
                    .toMillis()));

            System.out.println("最后访问时间：" + new Date(basicFileAttributes.
                    lastAccessTime().toMillis()));

            System.out.println("最后修改时间：" + new Date(basicFileAttributes.
                    lastModifiedTime().toMillis()));

            System.out.println("文件大小：" + basicFileAttributes.size());

            FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, 
                    FileOwnerAttributeView.class);

            System.out.println("文件所有者：" + ownerView.getOwner());


    }


}