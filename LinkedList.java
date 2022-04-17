public class LinkedList {
    private Node head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(int[] arr){
        head = null;
        for (int i = 0; i < arr.length; i++){
            Node n = new Node(arr[i]);
            Append(n);
        }
    }

    public void Append(int val){
        Node newNode = new Node();
        newNode.value = val;
        newNode.next  = null;
        // Yukaridaki 3 satirlik ifade yerine asagidaki yoruma cevrilmis ifade yazilabilirdi.
        // Node newNode = new Node(val); 

        if (head == null){
            head = newNode;
            return;
        }

        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = newNode;
    }

    public void Append(Node newNode){
        if (head == null){
            head = newNode;
            return;
        }

        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = newNode;
    }

    public void Print(){
        Node n = head;
        while (n != null){
            System.out.print("| " + n.value + " |" + " --> ");
            n = n.next;
        }
        System.out.println("|NULL|");
    }
     public void Print(Node h) {
        Node n = h;
        while (n != null) {
          System.out.print("| " + n.value + " |" + " --> ");
          n = n.next;
        }
        System.out.println("|NULL|");
      }

    // Bu metod bagli listenin elemanlarini sondan basa dogru sirali okarak ekrana yazdirir.
    // Bu metodun ciktisi Print metodununun ciktisinin yonu degistirilmis sekli olmalidir.
    // Bu metodu kodlamak icin dizi, ArrayList, String metodlari vb. kullanmayiniz.
    // Bu metodu recursive (oz yinelemeli) sekilde yazabilirsiniz. Bu metodu yazmak icin baska
    // bir metod tanimlayip PrintReverse metodu icinde tanimlamis oldugunuz bu metodu kullanabilirsiniz.

    public void PrintReverse(){
         var reversed = Reverse(head);
    	    Print(reversed);
    }
    public Node Reverse(Node h) {
    	
        Node prev = null;
        Node reversed = null;

        while (h != null) {
            prev = h;

            reversed = new Node(prev.value);

            h = h.next; 
             }

        return reversed;
        
    }

    // Bu metod bagli listedeki elemanlarin toplamini dondurur. 
    // Eger bagli liste bossa metod 0 degerini dondurmelidir. 

    public int Sum(){
         int sum = 0;
    	    Node n = head;

    	    while (n != null) {
    	      sum = sum + n.value;

    	      n = n.next;
    	    }

    	    return sum;
       
    }

    // IsSorted() bagli liste kucukten buyuge sirali ise true aksi durumda false dondurur.
    // Bagli liste bos ise veya tek elemanli ise IsSorted() true dondurur.

    public boolean IsSorted(){
         Node n = head;

		    while (n.next != null) {
		      if (n.value > n.next.value) {
		        return false;
		      }

		      n = n.next;
		    }

		    return true;
        
    }
    static Node newNode(int data)
	{
	    Node temp = new Node();
	    temp.next = null;
	    temp.value = data;
	    return temp;
	}

    // MergeSortedLists(LinkedList m, LinkedList n) parametre olarak iki tane kucukten
    // buyuge sirali bagli liste alir ve bu listelerdeki elemanlarin kucukten buyuge
    // siralandigi bir bagli liste dondurur.

    public static LinkedList MergeSortedLists(LinkedList m, LinkedList n){
         var result = new ArrayList<Integer>();

    	    var list1 = m.head;
    	    var list2 = n.head;

    	    while (list1 != null || list2 != null) {
    	      if (list1 == null) {
    	        result.add(list2.value);
    	        list2 = list2.next;
    	        continue;
    	      } else if (list2 == null) {
    	        result.add(list1.value);
    	        list1 = list1.next;
    	        continue;
    	      }

    	      if (list1.value < list2.value) {
    	        result.add(list1.value);
    	        list1 = list1.next;
    	      } else {
    	        result.add(list2.value);
    	        list2 = list2.next;
    	      }
    	    }

    	    int[] arr = result.stream().mapToInt(i -> i).toArray();

    	    return new LinkedList(arr);
        
    }
}
