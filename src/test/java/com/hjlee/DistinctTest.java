package com.hjlee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctTest {



	    public static void main(String[] args) {
	        List<HashMap<Object, Object>> list = new ArrayList<HashMap<Object,Object>>();

	        HashMap<Object, Object> item = new HashMap<Object, Object>();
	        item.put("key1", "a");
	        item.put("key2", "ㄱ");
	        item.put("key3", "1");
	        item.put("data", "test1");
	        list.add(item);

	        item = new HashMap<Object, Object>();
	        item.put("key1", "a");
	        item.put("key2", "ㄱ");
	        item.put("key3", "1");
	        item.put("data", "test1");
	        list.add(item);

	        item = new HashMap<Object, Object>();
	        item.put("key1", "a");
	        item.put("key2", "ㄱ");
	        item.put("key3", "2");
	        item.put("data", "test1");
	        list.add(item);

	        item = new HashMap<Object, Object>();
	        item.put("key1", "a");
	        item.put("key2", "ㄱ");
	        item.put("key3", "2");
	        item.put("data", "test1");
	        list.add(item);
	        
	        item = new HashMap<Object, Object>();
	        item.put("key1", "b");
	        item.put("key2", "ㄱ");
	        item.put("key3", "1");
	        item.put("data", "test1");
	        list.add(item);
	        
	        for(HashMap<Object, Object> re : list) {
	        	re.put("realKey", re.get("key1")+""+re.get("key2")+""+re.get("key3"));
	        }
	        //list.forEach(System.out::println);
	        
	        List<HashMap<Object, Object>> result = distinctArray(list, "realKey");
	        result.forEach(System.out::println);

	    }

	    //중복제거 메소드, key는 제거할 맵 대상
	    public static List<HashMap<Object, Object>> distinctArray(List<HashMap<Object, Object>> target, Object key){ 
	        if(target != null){
	            target = target.stream().filter(distinctByKey(o-> o.get(key))).collect(Collectors.toList());
	        }
	        return target;
	    }

	    //중복 제거를 위한 함수
	    public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
	        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	    }
}
