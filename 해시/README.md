# 📌 해시맵 (HashMap)
```
- 해시(Hash): 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 것
- 맵(Map): 키(Key)와 값(Value) 두 쌍으로 데이터를 보관하는 자료구조
```
- 키(key)는 중복된 값이 있으면 안된다.
- 값(value)은 중복되어도 상관 없다.
- 키를 해싱하여 자료를 저장하고 꺼내오기 때문에 속도가 빠르다.
- 사용법이 동일한 Collection에는 해시테이블(HashTable)이 있다. 해시테이블과의 차이점은 해시테이블은 Thread 관점에서 안전하고(Thread-Safe), 해시맵은 안전하지 않은 대신 속도가 빠르다.
- 커스터마이징한 객체를 키로 사용할 수 있다.

## 해시맵 사용법 
### 1. 키, 값 저장(put)과 읽기(get)
```java
import java.util.HashMap;
import java.util.Map;
public class Main {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();	//<키 자료형, 값 자료형>
		map.put("A", 100);
		map.put("B", 101);
		map.put("C", 102);
		map.put("C", 103); //중복된 key가 들어갈때는 이전 키,값을 지금의 것으로 덮어씀
		System.out.println(map);
		System.out.println(map.get("A"));
		System.out.println(map.get("B"));
		System.out.println(map.get("C"));
	}
}
```
결과 
```
{A=100, B=101, C=103}
100
101
103
// 만약 해당하는 key가 없다면 null 반환
```

### 2. containsKey (이미 HashMap에 키가 있으면 값을 덮어쓰지 X)
```java
public static void main(String[] args){
	Map<String,Integer> map = new HashMap()<>;
	map.put("key1", 100);
	map.put("key2", 200);
	if(!map.containsKey("key2"))	//키가 들어있는지 확인. 있으면 덮어쓰지 않는다. true or false
		map.put("key2", 300);
	System.out.println(map);
	System.out.println(map.get("key1"));
	System.out.println(map.get("key2"));
}
```
결과
```
{key1=100, key2=200}
100
200
```
### 2-1. containsValue
- 값(value)이 존재하는지 확인하는 메소드
- true or false 반환

### 2-2. putIfAbsent
- containsKey 대신에 쓸 수 있는 메소드 
```java
//if(!map.containsKey("key2"))
  //map.put("key2", 300); 
map.putIfAbsent("key2",300);
```

### 3. putAll (Map에 다른 Map을 전부 포함)
- map 전체를 인자로 넘겨주고 싶을 때 사용
- 반드시 키와 값의 자료형이 같은 map이어야 한다.
```java
public static void main(String[] args) {
	Map<String,Integer> map1 = new HashMap<>();
	Map<String,Integer> map2 = new HashMap<>();
	//map1 put
	map1.put("map1-key1", 100);
	map1.put("map1-key2", 200);
		
	//map2 put
	map2.put("map2-key3", 300);
	map2.put("map2-key4", 400);
		
	System.out.println("map1:"+map1);
	System.out.println("map2:"+map2);
		
	//map2에 map1을 합침
	map2.putAll(map1);
	System.out.println("map2 includes map1:"+map2);
		
	//map1의 키, 값 변경
	map1.put("map1-key1", 1000);
	//map2에는 영향 없음.
	System.out.println("map2 includes map1:"+map2);
}
```
결과
```
map1:{map1-key1=100, map1-key2=200}
map2:{map2-key4=400, map2-key3=300}
map2 includes map1:{map2-key4=400, map1-key1=100, map1-key2=200, map2-key3=300}
map2 includes map1:{map2-key4=400, map1-key1=100, map1-key2=200, map2-key3=300}
```
- __생성자__ 를 이용해서 생성과 동시에 Map의 데이터를 모두 넘겨줄 수 있다.
```java
Map<String,Integer> map2 = new HashMap<>(map1);
```

### 4. keySet (모든 키를 순회)
- 키를 Set으로 넘겨주어 Map에 존재하는 키를 모두 순회
```java
public static void main(String[] args) {
	Map<String,Integer> map = new HashMap<>();
	map.put("key1",50);
	map.put("key2",100);
	map.put("key3",150);
	map.put("key4",200);
		
	System.out.println("All key-value pairs");
	for(String key : map.keySet()) {
		System.out.println("{" + key + "," + map.get(key) + "}");
	}
}
```
결과
```
All key-value pairs
{key1,50}
{key2,100}
{key3,150}
{key4,200}
```

### 5. Foreach() 메소드로 순환
```java
public static void main(String[] args) {
	Map<String,Integer> hm = new HashMap<>();
	hm.put("http",80);
	hm.put("ssh", 22);
	hm.put("dns", 53);
	hm.put("telnet",23);
	hm.put("ftp", 21);

	hm.forEach((key,value)-> // 람다식
	{
		System.out.println("{" + key + "," + value + "}");
	});
}
```
결과
```
{ftp,21}
{telnet,23}
{dns,53}
{http,80}
{ssh,22}
```

### 6. 내가 만든 객체를 Key로 사용하기(나의 객체를 같은 키로 판단하는 방법)
```java
public class Main {
	public static void main(String[] args) {
		Person person1 = new Person("reakwon","666666-7777777");
		Person person2 = new Person("putty","123456-1234567");
		
		Person who = new Person("reakwon","666666-7777777");
		Map<Person,Integer> map = new HashMap<>();
		map.put(person1, 90);
		map.put(person2, 80);
		
		System.out.println("map includes " + who.getName() + "? " + map.containsKey(who));
	
		map.put(who, 70);
		System.out.println(map);
	}
}

class Person{
	private String name;
	private String id;

	public Person(String name,String id) {
		this.name=name;
		this.id=id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
```
결과
```
map includes reakwon? false
{putty=80, reakwon=70, reakwon=90}
```

### 6-1. hashCode() 메소드 Overriding
- who와 person1을 같은 키로 인식하고자 할 때
- hashCode는 각 객체가 갖는 유일한 값(Code)을 의미
- Object의 hashCode()는 원래 주소값에 의한 hashCode()로 각 객체가 전부 다른 값을 가진다.
- HashMap은 우선 hashCode를 비교하고 같을 때만 equals를 수행하여 정말 제대로 같은것인지 판별 -> HashMap은 애초에 hashCode()가 반환하는 값이 다르면 equals는 수행하지 않는다.
```java
@Override
	public int hashCode() {
		return name.hashCode()+id.hashCode();
	}	
	
	@Override
	public boolean equals(Object o) {
		return this.hashCode()==o.hashCode();
	}
```
결과
```
map includes reakwon? true
{reakwon=70, putty=80}
```

[📚 출처: https://reakwon.tistory.com/151]


## 💡 Map & HashMap의 차이점
```java
HashMap<String,Object> map = new HashMap<String,Object>();
Map<String,Object> map = new HashMap<String,Object>();
```
- HashMap이 구현하는 인터페이스의 차이
- 기능은 똑같지만 코드의 유지보수성에 차이가 있다.
- java에서는 HashMap 외에도 다양한 종류의 Map이 존재하고, 모두 Map 인터페이스를 구현하는 구조로 정의되어 있다. 따라서 두 번째 방식으로 HashMap을 선언하여 사용히면 나중에 HashMap이 아닌 다른 종류의 Map을 사용해야 하는 상황에서도 많은 코드 수정 없이 손 쉽게 이를 반영할 수 있다.
- 첫 번째 방식에서는 해당 map Object에서는 오직 HashMap에 대한 Object만을 담을 수 있기 때문에 유지보수성이 떨어진다.

---

# 📌 해시셋 (HashSet)
- HashSet은 Set 인터페이스의 구현클래스이다.
- Set은 __객체를 중복해서 저장할 수 없고__ 하나의 null 값만 저장할 수 있다.
- Set 인터페이스를 구현한 클래스로는 HashSet과 TreeSet이 있는데 __HashSet의 경우 정렬을 해주지 않고__ __TreeSet의 경우 자동으로 정렬__ 해준다는 차이점이 있다.
- Set은 주머니 형태이다. 비선형 구조이기에 __저장 순서가 없으며__ 그렇기에 __인덱스도 존재하지 않는다.__
- 그렇기에 값을 추가하거나 삭제할 때 내가 추가 혹은 삭제하고자 하는 값이 Set 내부에 있는지 검색한 뒤 추가나 삭제를 해야한다.
- 속도가 List 구조에 비해 느리다.

## 해시셋 사용법
### 1. HashSet 선언 
```java
Set<Integer> set1 = new HashSet<Integer>(); // HashSet 생성
Set<Integer> set2 = new HashSet<>(); // new에서 타입 파라미터 생략 가능
Set<Integer> set3 = new HashSet<Integer>(set1); // set1의 모든 값을 가진 HashSet 생성
Set<Integer> set4 = new HashSet<Integer>(10); // 초기 용량 지정 
Set<Integer> set6 = new HashSet<Integer>(Arrays.asList(1,2,3)); //초기값 지정
```

### 2. HashSet 값 추가, 삭제 - add(), remove(), clear()
```java
HashSet<Integer> set = new HashSet<Integer>(); // HashSet 생성
set.add(1); //값 추가
set.remove(1); // 값 1 제거 
set.clear(); // 모든 값 제거
```


### 3. HashSet 크기 - size()
```java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3)); // HashSet 생성
System.out.println(set.size());//set 크기 : 3
```


### 4. HashSet 비어있는지 확인 - isEmpty()
```java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));
System.out.println(map.isEmpty());// false
```

### 5. HashSet 값 검색 - contains()
```java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성
System.out.println(set.contains(1)); //set내부에 값 1이 있는지 check : true
```


### 6. HashSet 값 출력 - iterator()
- Set 컬렉션을 그냥 출력하게 되면 대괄호로 묶어서 set의 전체값이 출력된다.
- Set에는 인덱스로 객체를 가져오는 get(index)메소드가 없다.
- 대신 전체 객체를 대상으로 한번씩 반복해서 가져오는 반복자 Iterator를 제공한다.
```java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성
System.out.println(set); //전체출력 [1,2,3]
		
Iterator iter = set.iterator();	// Iterator 사용
while(iter.hasNext()) { // 값이 있으면 true 없으면 false
    System.out.println(iter.next());
}
```


### 7. HashSet -> List, List -> HashSet
```java
List<String> list = new ArrayList<>();
Set<String> set = new HashSet<>(list); // list->set
List<String> list = new ArrayList<>(set);// set->list
```


[출처: https://velog.io/@kimmjieun/Java-HashSet-%EC%82%AC%EC%9A%A9%EB%B2%95]


# 📌 LinkedHashSet
- HashSet과 동일한 구조를 가지지만 HashSet은 순서를 관리하지 않아 값을 출력할 때마다 다른 순서대로 출력된다.
- LinkedHashSet은 __순서를 유지하며__ 삽입된 순서대로 반복한다.
- HashSet과 동일한 특징들이 있는데 마찬가지로 __중복 값을 허용하지 않는다.__

## LinkedHashSet 사용법
### 1. LinkedHashSet 선언
```java
LinkedHashSet hs = new LinkedHashSet(); // 타입 설정x Object 입력
LinkedHashSet<LinkedHashSetDemo> demo = new LinkedHashSet<LinkedHashSetDemo>(); // 클래스로 타입 설정
LinkedHashSet<Integer> i = new LinkedHashSet<Integer>(); // Integer 타입 선언
LinkedHashSet<Integer> i2 = new LinkedHashSet(); // 뒷부분 타입 선언 생략 가능
LinkedHashSet<Integer> i3 = new LinkedHashSet<Integer>(10); // 크기 10으로 선언
LinkedHashSet<Integer> i4 = new LinkedHashSet<Integer>(Arrays.asList(1, 2, 3, 4)); // 선언과 동시에 초기 값 설정
		
LinkedHashSet<String> str = new LinkedHashSet<String>(); // String 타입 선언
LinkedHashSet<Character> ch = new LinkedHashSet<Character>(); // Char 타입 선언
```

### 2. LinkedHashSet 값 추가 - add()
```java
LinkedHashSet<String> str = new LinkedHashSet<String>(); // LinkedHashSet 선언
		
// 값 추가
str.add("Hello1");
str.add("World2");
str.add("Hello3");
str.add("World4");
str.add("World2");
```
- "World2"를 추가하지만 중복값이라 결과를 조회할 때는 제외하고 출력

### 3. LinkedHashSet 값 삭제 - remove(), clear()
```java
LinkedHashSet<String> str = new LinkedHashSet<String>(); // LinkedHashSet 선언
		
// 값 추가
str.add("Hello1");
str.add("World2");
str.add("Hello3");
str.add("World4");
		
System.out.println(str); // 결과 출력		
		
str.remove("World2"); // World2 값 삭제
System.out.println(str); // 결과 출력	
		
str.clear(); // 모든 값 삭제
System.out.println(str); // 결과 출력	
```

### 4. LinkedHashSet 크기 - size()
```java
LinkedHashSet<String> str = new LinkedHashSet<String>(); // LinkedHashSet 선언
		
// 값 추가
str.add("Hello1");
str.add("World2");
		
System.out.println("LinkedHashSet의 크기는? " + str.size()); // 결과 출력	
```

### 5. LinkedHashSet 값 출력 - iterator()
```java
LinkedHashSet<String> str = new LinkedHashSet<String>(); // LinkedHashSet 선언
		
// 값 추가
str.add("Hello1");
str.add("World2");
str.add("Hello3");
str.add("World4");
		
/* Iterator를 사용 HashSet 배열 출력 */
Iterator iter = str.iterator();
while(iter.hasNext())
	System.out.print(iter.next() + " ");
```


[출처: https://st-lab.tistory.com/258, https://crazykim2.tistory.com/582]
