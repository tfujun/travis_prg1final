 
public class SimpleLinkedListUtils {
	
	public static boolean contains(SimpleLinkedList list, String data) {
		boolean isTrue = false;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).contains(data)){
				isTrue = true;
			}
		}
		return isTrue;
	}
	
	public static int indexOf(SimpleLinkedList list, String data) {
		int indexOf = -1;
		for(int i=0;i < list.size(); i++){
			if(list.get(i).equals(data)){
				indexOf = i;
				break;
			}
		}
		return indexOf;
	}
	
	public static int lastIndexOf(SimpleLinkedList list, String data) {
		int indexOf = -1;
		for(int i = 0; i<list.size();i++){
			if(list.get(i).equals(data)){
				indexOf = i;
			}
		}
		return indexOf;
	}
	
	public static int count(SimpleLinkedList list, String data) {
		int listCount = 0;
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).equals(data)){
				listCount++;
			}
		}
		return listCount;
	}
	
	public static void remove(SimpleLinkedList list, String data) {
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).equals(data)){
				list.remove(i);
				break;
			}
		}
	}
	
	public static String[] toArray(SimpleLinkedList list) {
		String[] stringArray = new String[list.size()];
		for(int i=0; i<list.size(); i++){
			stringArray[i] = list.get(i);
		}
		return stringArray;
	}
	
	public static String toString(SimpleLinkedList list) {
		String listString = "[";
		if(list.size() == 0){
				listString = listString +"]";
			}
		for(int i=0; i<list.size(); i++){
			if(i==(list.size()-1)){
				listString = listString + list.get(i)+"]";
				break;
			}
			listString = listString+list.get(i)+", ";
		}
		
		return listString;
	}
	
	public static boolean equals(SimpleLinkedList list1, SimpleLinkedList list2) {
		boolean isTrue = false;
		String listString1 = "";
		String listString2 = "";
		if(list1.size() == list2.size()){
			for(int i = 0; i<list1.size(); i++){
				listString1 = listString1 +list1.get(i);
			}
			for(int i=0; i<list2.size(); i++){
				listString2 = listString2 +list2.get(i);
			}
			if(listString1.equals(listString2)){
				isTrue = true;
			}
		}
		return isTrue;
	}
	
	public static SimpleLinkedList reverse(SimpleLinkedList list) {
		SimpleLinkedList reversed = new SimpleLinkedList();
		for(int i =list.size()-1; i>=0; i--){
			reversed.add(list.get(i));	
		}
		return reversed;
	}
	
	public static SimpleLinkedList removeDuplicates(SimpleLinkedList list) {
		SimpleLinkedListUtils listUtils = new SimpleLinkedListUtils();
		SimpleLinkedList noDupeList = new SimpleLinkedList();

		for(int i = 0; i <list.size(); i++){
			if(listUtils.contains(noDupeList, list.get(i))){
				continue;
			}
			else{
				noDupeList.add(list.get(i));
			}
		}
		return noDupeList;
	}
	
	public static SimpleLinkedList sort(SimpleLinkedList list) {
		SimpleLinkedList sortedList = new SimpleLinkedList();
		String smallestString;
		int smallestIndex;
		for(int i=0; i<list.size()-1; i++){
			smallestIndex = i;
			for(int j=i+1; j<list.size(); j++){
				if(SimpleLinkedListUtils.lessThan(list.get(j), list.get(smallestIndex))){
					smallestIndex = j;
				}
			}
			smallestString = list.get(smallestIndex);
			list.set(smallestIndex, list.get(i));
			list.set(i, smallestString);
			
		}
		for(int i =0; i<list.size(); i++){
			sortedList.add(list.get(i));
		}
		return sortedList;
	} 

	private static boolean lessThan(String a, String b) {
		return a.compareTo(b) < 0;
	}
}

