package org.mstory.bbs.common;

//java�ڵ�� �뷮�� �����͸� �����ͺ��̽��� �ֱ�(���̵����� �����)
public class MakeSQL {
	
	public static void main(String[] args) {
		
		int max = 8388609;
		
/*		for(int i=467; i<533; i++) {
			
			int value = (int)(Math.random()*100);
			
			String sql = "insert into tbl_book (bno, title, writer, publisher ,pubyear, keyword, state)"
							+ "values(seq_bno.nextval, '������" + i + "', '������" + i + "', '���ǻ�" + i + "', to_date('2012/05/13','yyyy/mm/dd'), 'ååå" + i + "', 3);";
			
			System.out.println(sql);
		} //�̰� �����ؼ� ���°���� �ܾ DB�� �״�� �ִ´�!
*/		
		for(int i=0; i<10; i++) {

			String sql = "insert into tbl_reply(rno, bno, replyer, reply)"
					+ " values(seq_rno.nextval, 773, '�ۼ���" + i + "', '���..." + i + "');";
			
			System.out.println(sql);
		}
	}
}
