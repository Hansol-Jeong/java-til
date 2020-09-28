package com.company;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerList {

    Consumer<String> NPC1_elder = s-> System.out.println("마을 할아버지: " + s);
    Consumer<String> SYSTEM =s-> System.out.println("@SYSTEM: " + s);
    Consumer<String> SYSTEM_Gain =s-> System.out.println("@SYSTEM: " + s +"을(를) 획득하였다!");
    Consumer<String> SYSTEM_Abandon =s-> System.out.println("@SYSTEM: " + s +"을(를) 버렸습니다.");
    BiConsumer<String, String> SYSTEM_Battle1 = (t, u) -> System.out.println("@SYSTEM: "+t +"이(가)"+u+"에게 공격하였습니다.");
    Consumer<String> SYSTEM_SomthingDead=s-> System.out.println(s+"이(가) 사망했습니다.");
    Consumer<String> Hero=s-> System.out.println("용사: "+s);
    Consumer<String> Narration = System.out::println;
    Consumer<String> SpeedWagon = s->System.out.println("스피드웨건: "+s);
}
