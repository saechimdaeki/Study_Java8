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

# 4. 람다 표현식
#### 람다
- (인자리스트) -> {바디}
#### 인자리스트
- 인자가 없을 때:()
- 인자가 한개일 때:(one) 또는 one
- 인자가 여러개 일떄: (one,two)
- 인자의 타입은 생략 가능, 컴파일러가 추론하지만 명시할 수도 있다. 
#### 바디
- 화살표 오른쪽에 함수 본문을 정의한다.
- 여러 줄인 경우에 {}를 사용해서 묶는다.
- 한 줄인 경우에 생략 가능, return도 생략 가능
#### 변수 캡처
- 로컬 변수 캡처
    - final이거나 effetiv final인 경우에만 참조할 수 있다.
    - 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일러가 방지한다.
- effective final
    - 이것도 역시 자바 8부터 지원하는 기능으로 "사실상" fianl인 변수
    - final 키워드 사용하지 않은 변수를 익명 클래스 구현체 또는 람다에서 참조할 수 있다.
- 익명 클래스 구현체와달리 '쉐도윙'하지 않는다.
    - 익명 클래스는 새로 스콥을 만들지만 람다는 람다를 감싸고 있는 스콥과 같다.        
