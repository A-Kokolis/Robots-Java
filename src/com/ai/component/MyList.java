package com.ai.component;


public class MyList {
	
	public Node first = null;
	
	public void insert(Node n){
		if(first == null)
			first = n;
		else{
			n.next = first;
			first = n;
		}
		
	}
	
	public void print(){
		Node cur = first;
		if(cur == null){
			System.out.println("adeia");
		}else{
			while(cur != null){
				System.out.println(cur.getNodeChar());
				cur = cur.next;
			}
		}
	}
    public void insertSort (Node item ){
        Node temp = new Node(item);
        Node current;
        Node temp2 ;
        if (isEmpty()){
            first= new Node(item);}
        else{
            current=first;
            temp2=first;
            if (current.gethCost()+current.getCost() > temp.gethCost()+temp.getCost()){
            	temp.next=first;
            	first=temp;
            }else {
            while (current!=null){
               if (current.gethCost()+ current.getCost() < temp.gethCost()+temp.getCost()){
                   temp2=current;
                   current=current.next;                   
               }
               else{
                   Node next = temp2.next;
                   temp2.next = temp;
                   temp.next = next;
                   break;
               }
            }
            if (current == null){
             temp2.next =temp;}
    }
        }
    }


	public boolean isEmpty() {
		return first== null;
	}

	public void removeFirst() {
		if(first.next == null){
			first = null;
		}else{
			first = first.next;
		}
		
	}

}
