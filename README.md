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

# 5. 메소드 레퍼런스
#### 람다가 하는일이 기존메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해 매우 간결표현할수있다.

### 메소드를 참조하는 방법
|`방법`|`설명`|
|--|--|
| 스태틱 메소드 참조  | 타입::스태틱 메소드   |
|특정 객체의 인스턴스 메소드 참조   | 객체레퍼런스::인스턴스메소드  |
|임의 객체의 인스턴스 메소드 참조|타입::인스턴스 메소드|
|생성자참조|타입::new|
- 메소드 또는 생성자의 매개변수로 람다의 입력값을 받는다.
- 리턴값 또는 생성한 객체는 람다의 리턴값이다.

# 6. 인터페이스 기본 메소드와 스태틱 메소드
#### 기본 메소드(Default Methods)
- 인터페이스에 메소드 선언이 아니라 구현체를 제공하는 방법
- 해당 인터페이스를 구현한 클래스를 깨트리지 않고 새기능을 추가할 수 있다.
- 기본메소드는 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있다.
    - 컴파일 에러는 아니지만 구현체에 따라 런타임 에러가 발생할 수 있다.
    - 반드시 문서화 할 것.(@implSpec 자바독 태그 사용)
- Object가 제공하는 기능(equals,hasCode)는 기본 메소드로 제공할 수 없다.
    - 구현체가 재정의해야 한다.
- 본인이 수정할 수 있는 인터페이스에만 기본 메소드를 제공할 수 있다.
- 인터페이스를 상속받는 인터페이스에서 다시 추상메소드로 변경할 수 있다.
- 인터페이스 구현체가 재정의 할 수도 있다.
#### 스태틱 메소드
- 해당 타입 관련 헬터 또는 유틸리티 메소드를 제공할 때 인터페이스에 스태틱 메소드를 제공할 수 있다.

# 7. 자바8 API의 기본 메소드와 스태틱 메소드
#### 자바 8 에서 추가한 기본 메소드로 인한 API변화

### Iterable의 기본 메소드
- forEach()
- spliterator()

### Collection의 기본 메소드
- stream()/parallelStream()
- removeIf(Predicate)
- spliterator()

### Comparator의 기본 메소드 및 스태틱 메소드
- reversed()
- thenComparing()
- static reverseOrder()/ naturalOrder()
- static nullsFirst()/nullsLast()
- static comparing()


# 8 Stream 소개
### Stream
- sequence of elements supporting sequential and parallel aggregate operations
- 데이터를 담고 있는 저장소(컬렉션)이 아니다.
- Functional in nature, 스트림이 처리하는 데이터 소스를 변경하지 않는다.
- 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
- 무제한일 수도 있다. (Short Circuit 메소드를 사용해서 제한할 수 있다.)
- 중개 오퍼레이션은 근본적으로 lazy하다.
- 손쉽게 병렬 처리할 수 있다.

### 스트림 파이프 라인
- 0 또는 다수의 중개 오퍼레이션과 한개의 종료 오퍼레이션으로 구성한다.
- 스트림의 데이터 소스는 오직 터미널 오퍼네이션을 실행할 때에만 처리한다.

### 중개 오퍼레이션
- Stream을 리턴한다.
- Stateless/stateful 오퍼레이션으로 더 상세하게 구분할 수도 있다.
- filter,map,limit,skip,sorted, ... 

### 종료 오퍼레이션
- Stream을 리턴하지 안흔ㄴ다.
- collect,allMatch,count,forEach,min,max,...

# 9 Stream API

### 걸러내기
- Filter(Predicate)
- 예) 이름이 3글자 이상인 데이터만 새로운 스트림으로

### 변경하기
- Map(Function) 또는 FlatMap(Function)
- 예) 각각의 Post 인스턴스에서 String title만 새로운 스트림으로
- 예) List< Stream< String>> 을 String의 스트림으로

### 생성하기
- generate(Supplier) 또는 Iterate(T seed, UnaryOperator)
- 예) 10부터 1씩 증가하는 무제한 숫자 스트림
- 예) 랜덤 int 무제한 스트림

### 제한하기
- limit(long)또는 skil(long)
- 예) 최대 5개의 요소가 담긴 스트림을 리턴한다.
- 예) 앞에서 3개를 뺀 나머지 스트림을 리턴한다.

### 스트림에 있는 데이터가 특정 조건을 만족하는지 확인
- anyMatch(),allMatch(),nonMatch()
- 예) k로 시작하는 문자열이 있는지 확인한다.(true 또는 false를 리턴)
- 예) 스트림에 있는 모든값이 10보다 작은지 확인한다.

### 개수 세기
- count()
- 예) 10보다 큰 수의 개수를 센다

### 스트림을 데이터 하나로 뭉치기
- reduce(identity, BiFunction), collect(), sum(), max()
- 예) 모든 숫자 합 구하기
- 예) 모든 데이터를 하나의 List 또는 Set에 옮겨 담기

# 10 Optional 소개
### 자바 프로그래밍에서 NullPointerException을 종종 보게되는 이유
- null을 리턴하니까!
- null체크를 깜빡했으니까!
### 메소드에서 작업중 특별한 상황에서 값을 리턴할 수 없는경우 선택할 수 있는 방법
- 예외를 던진다(비싸다, 스택트레이스를 찍어두니까)
- null을 리턴한다
- Optional을 리턴한다 

## OpTIONAL
- 오직 값 한개가 들어있을 수 도 없을 수 도있는 컨테이너
### 주의할 것
- 리턴값으로만 쓰기를 권장한다 (메소드 매개변수 타입, 키타입, 인스턴스 필드타입으로 쓰지말자)
- Optional을 리턴하는 메소드에서 null을 리턴하지 말자.
- 프리미티브 타입용 Optional은 따로있다 . OptionalInt,OptionalLong,...
- Collection,Map,Stream Array, Optional은 Optioanal로 감싸지 말 것.

