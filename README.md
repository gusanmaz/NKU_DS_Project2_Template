# Proje Aciklamalari

* LinkedList.java dosyasindaki yorum satirlarini okuyup, ilgili metod ve fonksiyonlarda gerekli degisiklikleri yapiniz.
* Calisir hale getirmeniz gereken metod ve fonksiyonlar Sum, PrintReverse, IsSorted ve MergeSortedLists'dir.
* Yukarida ismi gecen metod ve fonksiyonlarin imzalarinda bir degisiklik yapmayiniz.
* Sablon kodda verilen diger metodlarda, fonksiyonlarda (main haric) ve constructor'larda degisiklik yapmayiniz.
* Sablon koddaki dosya isimlerinde ve sinif isimlerinde degisiklik yapmayiniz.
* Proje son gonderim tarihi **17 Nisan 2022 23:59**'dur.
* Proje iceriginde degisiklikler, eklemeler, duzeltmeler yapilabilir. Lutfen universite email hesaplarinizi, [BMB212 Github sayfasini](https://github.com/gusanmaz/NKU_DS_Course_2022) ve [Ders Github Issues sayfasini](https://github.com/gusanmaz/NKU_DS_Course_2022/issues) duzenli takip ediniz.
* Projeleriniz otomatik program tarafindan degerlendirilecektir. Gondereceginiz kodlarin derlendigine ve tam olarak projede istenilen sekilde olmasina dikkat ediniz.
* Bu proje bireysel bir projedir. Kesinlikle baskasindan aldiginiz kodlari gondermeyiniz!
* Projeye ogrenci_numaram.txt (ornegin ogrenci numaraniz 1234567890 ise 1234567890.txt) isimli bos bir dosya ekleyiniz. Bu dosya herhangi bir alt dizinde olmasin. Bu dosya Main.java Node.java gibi dosyalarin oldugu yerde olmalidir.

# Projenin Derlenmesi

```bash
javac *.java
```

# Projenin Calistirilmasi

Sablon dosyadaki main fonksiyonun icerigi asagidaki gibidir. 

```java
public static void main(String[] args){
        // main altinda linkedlist sinifi icin yazdiginiz metodlarin dogru
        // calisip calismadigini test edebilirsiniz.
        // main altinda yazacaginiz kodlar derleme hatasi uretmedigi surece
        // notlandirmaya olumlu veya olumsuz etkisi olmayacaktir.

        LinkedList list = new LinkedList();
        list.Append(5);
        list.Append(6);
        list.Append(2);
        list.Print();
        System.out.println(list.Sum());
        System.out.println(list.IsSorted());

        int[] num1 = {1,6,7,9,14};
        int[] num2 = {-1, 4,8,10,11,15,19};
        LinkedList a = new LinkedList(num1);
        LinkedList b = new LinkedList(num2);
        a.Print();
        System.out.println(a.IsSorted());
        b.Print();
        System.out.println(b.IsSorted());

        LinkedList c = LinkedList.MergeSortedLists(a,b);
        c.Print();
        System.out.println(c.IsSorted());
        System.out.println(c.Sum());
        c.PrintReverse();
    }
```

LinkedList sinifinda istenilen degisikler dogru bir sekilde yapilir ve main fonksiyonunuzun icerigi yukaridaki gibi olursa programiniz calistirdiginizda alacaginiz cikti asagidaki gibi olacaktir.

```bash
java Main
| 5 | --> | 6 | --> | 2 | --> |NULL|
13
false
| 1 | --> | 6 | --> | 7 | --> | 9 | --> | 14 | --> |NULL|
true
| -1 | --> | 4 | --> | 8 | --> | 10 | --> | 11 | --> | 15 | --> | 19 | --> |NULL|
true
| -1 | --> | 1 | --> | 4 | --> | 6 | --> | 7 | --> | 8 | --> | 9 | --> | 10 | --> | 11 | --> | 14 | --> | 15 | --> | 19 | --> |NULL|
true
103
|NULL| <-- | 19 | <-- | 15 | <-- | 14 | <-- | 11 | <-- | 10 | <-- | 9 | <-- | 8 | <-- | 7 | <-- | 6 | <-- | 4 | <-- | 1 | <-- | -1 |
```

# Sablon Proje Kodlari

Asagida bu repoda verilen sablon kodlar bulunmaktadir. Uzerinde degisiklik yaptiginiz dosyalarin ilk hallerine buradan ulasabilirsiniz.

### Node.java

```java
public class Node {
    public int value;
    public Node next;

    public Node(int v){
        value = v;
        next  = null;
    }

    public Node(){
        
    }

}
```

### LinkedList.java

```java
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
        
    }

    // Bu metod bagli listedeki elemanlarin toplamini dondurur.

    public int Sum(){
       
    }

    // IsSorted() bagli liste kucukten buyuge sirali ise true aksi durumda false dondurur.
    // Bagli liste bos ise veya tek elemanli ise IsSorted() true dondurur.

    public boolean IsSorted(){
        
    }

    // MergeSortedLists(LinkedList m, LinkedList n) parametre olarak iki tane kucukten
    // buyuge sirali bagli liste alir ve bu listelerdeki elemanlarin kucukten buyuge
    // siralandigi bir bagli liste dondurur.

    public static LinkedList MergeSortedLists(LinkedList m, LinkedList n){
        
    }
}
```

### Main.java

```java
public class Main {
    public static int[] Reverse(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++){
            b[i] = a[a.length - 1 - i];
        }
        return b;
    }

    public static void main(String[] args){
        // main altinda linkedlist sinifi icin yazdiginiz metodlarin dogru
        // calisip calismadigini test edebilirsiniz.
        // main altinda yazacaginiz kodlar derleme hatasi uretmedigi surece
        // notlandirmaya olumlu veya olumsuz etkisi olmayacaktir.

        LinkedList list = new LinkedList();
        list.Append(5);
        list.Append(6);
        list.Append(2);
        list.Print();
        System.out.println(list.Sum());
        System.out.println(list.IsSorted());

        int[] num1 = {1,6,7,9,14};
        int[] num2 = {-1, 4,8,10,11,15,19};
        LinkedList a = new LinkedList(num1);
        LinkedList b = new LinkedList(num2);
        a.Print();
        System.out.println(a.IsSorted());
        b.Print();
        System.out.println(b.IsSorted());

        LinkedList c = LinkedList.MergeSortedLists(a,b);
        c.Print();
        System.out.println(c.IsSorted());
        System.out.println(c.Sum());
        c.PrintReverse();
    }
}

```
