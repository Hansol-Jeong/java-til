package com.company.s11;
/**
 3.List의 정렬을 위해서 Comparable 이 아닌 Comparator 을 쓸 수도 있다

 4.Comparable인터페이스가 없을 때만 Comparator을 구현해서 쓴다.(TreeSet)
 둘다 hashcode를 사용하기 떄문에 요소의 중복을 허용하지 않지만(HashMap의 경우 key만 HashCode를 갖고 있기 때문에 Key의 중복이 허용되지 않고,Hashset의 경우 값에 대해서 HashCode가
 적용되기 때문에 값의 중복이 허용되지 않는다.)
 **/