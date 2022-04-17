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

    // Bu metod bagli listenin elemanlarini sondan basa dogru sirali okarak ekrana yazdirir.
    // Bu metodun ciktisi Print metodununun ciktisinin yonu degistirilmis sekli olmalidir.
    // Bu metodu kodlamak icin dizi, ArrayList, String metodlari vb. kullanmayiniz.
    // Bu metodu recursive (oz yinelemeli) sekilde yazabilirsiniz. Bu metodu yazmak icin baska
    // bir metod tanimlayip PrintReverse metodu icinde tanimlamis oldugunuz bu metodu kullanabilirsiniz.

    public void PrintReverse(){
        System.out.print("|NULL|");
        Node n = head;
        RecursiveReverse(n);
        System.out.print(" <-- | "+n.value+" |");
    }
    
     public void RecursiveReverse(Node currNode){
      if(currNode==null)return;
      if(currNode.next==null){
        this.head=currNode;
        return;
      }
      RecursiveReverse(currNode.next);
      System.out.print(" <-- | "+currNode.next.value+" |");
      currNode.next=currNode;
    }

    // Bu metod bagli listedeki elemanlarin toplamini dondurur. 
    // Eger bagli liste bossa metod 0 degerini dondurmelidir. 

    public int Sum(){
       int sum = 0;
      Node n = head;
       
      while (n != null) {
        sum += n.value;
        n = n.next;
      }
       return sum;
    }

    // IsSorted() bagli liste kucukten buyuge sirali ise true aksi durumda false dondurur.
    // Bagli liste bos ise veya tek elemanli ise IsSorted() true dondurur.

    public boolean IsSorted(){
        Node n = head;
       Node t;
      if (n == null)
        return true;
 
      for (t = head; t.next != null; t = t.next) {
           if (t.value >= t.next.value){
              return false;
           }
      }
      return true;
    }

    // MergeSortedLists(LinkedList m, LinkedList n) parametre olarak iki tane kucukten
    // buyuge sirali bagli liste alir ve bu listelerdeki elemanlarin kucukten buyuge
    // siralandigi bir bagli liste dondurur.

    public static LinkedList MergeSortedLists(LinkedList m, LinkedList n){
        Node headm=m.head;
        Node headn=n.head;
        LinkedList list=new LinkedList();
        if(headm.value <= headn.value)
        {
            list.head =new Node(headm.value);
            headm = headm.next;
        }
        else
        {
            list.head =new Node(headn.value);
            headn = headn.next;
        }
        Node listNode=list.head;
        while(true){
        if (headm == null && headn==null) {
          break;
        }
        
        if (headm == null){
          listNode.next=headn;
          headn = headn.next;
          
        }else if(headn == null){
          listNode.next=headm;
          headm = headm.next;
        }
        else if(headm.value <= headn.value)
        {
            listNode.next = headm;
            headm = headm.next;
        }
        else
        {
            listNode.next = headn;
            headn = headn.next;
        }
         
        listNode = listNode.next;
        }
        
        return list;
    }
}
