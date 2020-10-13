package com.company.s11;

import javax.imageio.spi.ImageInputStreamSpi;
import javax.print.URIException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * I/O->Input/Output
 * 자바의 I/O방식은 Node-Stream
 * 노드는 키보드(입력),모니터(출력), 파일(입출력), 메모리(입출력), Database, 다른프로그램
 * Stream: 노드로부터 데이터를 주고 받는 통로
 * 입력으로사용되는 스트림과 출력으로 사용되는 스트림은 별개
 * 입출력을 함께하는 것은 채널-NIO(New Input/Output)
 */
public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //입력 스트림/리더
        //Stream/Reader 등을 사용하는 이유는
        //노드(입출력 장치/파일/메모리)으로부터 데이터를 읽고 쓰는 기본적인 방식
        //보통은 컴퓨터를 사용ㅇㅎ아지만. Embedded machine의 경우 Stream을 사용하는 경우가 많다.
        //그래서 Scanner가 편리하기는 하지만. Stream/Reader 동작을 이해할 필요가 있다.

        //Stream - byte 단위로 읽고 쓰는 특징
        //byte 단위로 읽어서 int로 출력함
        //영어 알파벳은 byte단위로 끊어도 되지만 한글 글자는 byte단위로 끊으면 읽고 쓸 수 없음.
        try  {
            InputStream input = System.in;
            int read = -1;
            while((read = input.read())!=-1) {
                System.out.printf("Int: %d Char: %c\n",read, read);
            }
        }
        catch(IOException e) {
            int read = 0;
            e.printStackTrace();
        }
//        try(InputStream input = System.in) {
//            int read = 0;
//            byte [] bytes = new byte[512];
//            while((read = input.read(bytes))!=-1) {//bytes에 담아준다
//                System.out.println(Arrays.toString(bytes));//512개의 bytes배열을 보여달라
//                System.out.println(read);
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        //Stream과 유사하나, Reader는 Char단위로 읽어서 int로 반환
        //Stream을 이용해서 Reader를 초기화 할 수 있음
//        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            int read = -1;
//            while((read = reader.read())!=-1) {//한글을 표기할 수 있는 4byte단위로 끊음
//                System.out.printf("Int: %d Char: %c\n",read,read);
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        try(InputStreamReader reader = new InputStreamReader(System.in)) {
//            int read = -1;
//            char [] cbuf = new char[100];
//            while((read = reader.read(cbuf))!=-1) {//4bytes씩 읽어서 int로 반환하고 cbuf에 저장, 그리고 그 int 는 read에 반환
//                System.out.println(Arrays.toString(cbuf));
//                System.out.println(read);
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
