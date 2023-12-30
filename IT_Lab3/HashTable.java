public class HashTable {

    public HashNode[] buckets;
    private int numOfBuckets;
    private int size;
    public HashTable() {
        this(5);
    }
    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }

    class HashNode {
        private Integer orderNum;
        private String clientInfo;
        private HashNode next;

        public HashNode(Integer orderNum, String clientInfo) {
            this.orderNum = orderNum;
            this.clientInfo = clientInfo;
        }
    }

    public String get(Integer orderNum) {
        if (orderNum == null)
            throw new IllegalArgumentException("orderNum is null");
        int bucketIndex = orderNum % numOfBuckets;
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.orderNum.equals(orderNum)) {
                return head.clientInfo;
            }
            head = head.next;
        }
        return null;
    }

    public void put(Integer orderNum, String clientInfo) {
        int bucketIndex = orderNum % numOfBuckets;
        size++;
        HashNode head = buckets[bucketIndex];
        HashNode node = new HashNode(orderNum, clientInfo);
        node.next = head;
        if (head == null)
            buckets[bucketIndex] = node;
        else
            buckets[bucketIndex].clientInfo = buckets[bucketIndex].clientInfo + " | " + node.clientInfo;
    }

    public String remove(Integer orderNum) {
        if (orderNum == null)
            throw new IllegalArgumentException("orderNum is already null");
        int bucketIndex = orderNum % numOfBuckets;
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        while (head != null) {
            if (head.orderNum.equals(orderNum)) {
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (previous != null) {
            previous.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }
        return head.clientInfo;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void output(){
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null)
                System.out.println(i);
            else
                System.out.println(i + " " + buckets[i].clientInfo);
        }
    }
}
