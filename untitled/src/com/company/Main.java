package com.company;

import java.io.File;

class Main{
    public static void main(String[] args) {
//        try{
//            File f = createFile("vkfk");
//            System.out.println(f.getName() + " 파일이 성공적으로 생성");
//        } catch (Exception e) {
//            System.out.println( e.getMessage() + " 다시 입력 ! ");
//        }
        System.out.println(args);
    }


    static File createFile(String fileName) throws Exception {

        if (fileName == null || fileName.equals("")){
            throw new Exception("유효하지않은 파일이름");
        }
        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
}