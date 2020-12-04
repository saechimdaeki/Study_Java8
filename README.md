# Study_Java8
### 자바8문법에 관련한 스터디 레포지토리 입니다.

# 1. 자바 8 소개
### 자바 8
- LTS 버전
- 출시일: 2014년 3월
- 현재 자바 개발자 중 약 83%가 사용 중
### 주요 기능
- 람다 표현식
- 메소드 레퍼런스
- 스트림 API
- Optional< T >
- ...

# 2. 함수형 인터페이스와 람다 표현식
### 함수형 인터페이스(Functional Interface)
- 추상 메소드를 딱 하나만가지고 있는 인터페이스
- SAM(Single Abstract Method) 인터페이스
- @FuncationInterface 애노태이션을 가지고 있는 인터페이스
### 람다 표현식(Lambda Expressions)
- 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
- 코드를 줄일 수 있다.
- 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.
### 자바에서 함수형 프로그래밍
- 함수를 First class object로 사용할 수 있다.
- 순수 함수(Pure function)
    - 사이드 이펙트가 없다(함수 밖에 있는 값을 변경하지않음)
    - 상태가 없다(함수 밖에 있는 값을 사용하지 않음)
- 고차 함수(Higher-Order Function)
    - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수 있다.
- 불변성        

# 3. 자바에서 제공하는 함수형 인터페이스
### Java가 기본으로 제공하는 함수형 인터페이스
- java.lang.function 패키지
- 자바에서 미리 정의해둔자주 사용할 만한 함수 인터페이스
- Function< T,R>
- BiFunction< T,U,R>
- Consumer< T>
- Supplier< T>
- Predicate< T>
- UnaryOperator< T>
- BinaryOperator< T>

#### Function< T,R>
- T타입을 받아서 R타입을 리턴하는함수 인터페이스
    - R apply(T t)
- 함수 조합용 메소드
    - andThen
    - compose
#### BiFunction< T,U,R>
- 두개의 값(T,U)를 받아서 R타입을 리턴하는 함수 인터페이스
    - R apply(T t,U u)

#### Consumer< T>
- T타입을 받아서 아무값도리턴하지 않는 함수 인터페이스
    - void Accept(T t)
- 함수 조합용 메소드
    - andThen
#### Supplier< T>
- T타입의 값을 제공하는 함수 인터페이스
    - T get()
#### Predicate< T>
- T타입을 받아서 boolean을 리턴하는함수 인터페이스
    - boolean test(T t)
- 함수 조합용 메소드
    - And
    - Or
    - Negate
#### UnaryOperator< T>
- Function< T,R>의 특수한 형태로 입력값 하나를 받아서 동일한 타입을 리턴하는 함수인터페이스

#### BinaryOperator< T>
- BiFunction< T,U,R>의 특수한 형태로, 동일한 타입의 입력값 두개를 받아 리턴하는 함수인터페이스
