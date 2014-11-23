package org.mstory.bbs.common;

//java코드로 대량의 데이터를 데이터베이스에 넣기(더미데이터 만들기)
public class MakeSQL {
	
	public static void main(String[] args) {
		
		int max = 8388609;
		
/*		for(int i=467; i<533; i++) {
			
			int value = (int)(Math.random()*100);
			
			String sql = "insert into tbl_book (bno, title, writer, publisher ,pubyear, keyword, state)"
							+ "values(seq_bno.nextval, '디자인" + i + "', '디자인" + i + "', '출판사" + i + "', to_date('2012/05/13','yyyy/mm/dd'), '책책책" + i + "', 3);";
			
			System.out.println(sql);
		} //이걸 실행해서 나온결과를 긁어서 DB에 그대로 넣는다!
*/		
		for(int i=0; i<10; i++) {

			String sql = "insert into tbl_reply(rno, bno, replyer, reply)"
					+ " values(seq_rno.nextval, 773, '작성자" + i + "', '댓글..." + i + "');";
			
			System.out.println(sql);
		}
	}
}
