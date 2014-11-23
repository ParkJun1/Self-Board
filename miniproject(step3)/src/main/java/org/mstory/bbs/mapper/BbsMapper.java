package org.mstory.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mstory.bbs.common.Criteria;
import org.mstory.bbs.vo.BbsVO;

public interface BbsMapper {

	@Select("select * from tbl_book where keyword like '%����%'")
	public BbsVO getBookTest();
	
	/*@Insert("insert into tbl_book(bno, title, writer, publisher ,pubyear, keyword, state) "
	        + "values(seq_bno.nextval, #{title}, #{writer}, #{publisher}, #{pubyear}, #{keyword}, 1)")*/
	public void create(BbsVO vo) throws Exception;
	
	@Update("update tbl_book set viewcnt = viewcnt + 1 where bno = #{bno}")
	public void viewCntUpdate(Integer bno) throws Exception;
	
	@Select("select bno, title, writer, publisher, pubyear, keyword, regdate, state, viewcnt, isFile "
			+ "from tbl_book where bno=#{bno}")
	public BbsVO read(Integer bno) throws Exception;
	
	@Update("update tbl_book set writer = #{writer}, title = #{title}, publisher = #{publisher}, " 
			+ "pubyear = #{pubyear}, keyword = #{keyword} where bno = #{bno}")
	public void update(BbsVO vo) throws Exception;
	
	@Delete("delete from tbl_book where bno = #{bno}")
	public void delete(Integer bno) throws Exception;
	
	//Mapper Interface�� �޼ҵ忡 @�� ���ٸ� xml�� ������!
	public List<BbsVO> readList(Criteria cri) throws Exception;
	
	public List<BbsVO> searchList(Criteria cri) throws Exception;
	
	//��� ���� ��������
	@Select("select " 
			  + "count(rno) replycnt " 
			  + "from " 
			  + "tbl_reply " 
			  + "where bno = #{bno}")
	public Integer cntReply(Integer bno);
	
	//���� �̸� �ֱ�
	@Insert("insert into tbl_file(fno, bno, filename) "
			+ "values(seq_fno.nextval, #{bno}, #{filename})")
	public void fileInsert(BbsVO vo) throws Exception;
	
	//�ش� bno�� ÷�ε� ���� �̸� ��������
	@Select("select " 
			 + "filename " 
			 + "from tbl_file " 
			 + "where bno=#{bno}")
	public List<String> fileRead(Integer bno) throws Exception;
	
	@Insert("insert into tbl_test1(name) values(#{a})")
	public void test1(String a) throws Exception;
	
	@Insert("insert into tbl_test2(name) values(#{b})")
	public void test2(String b) throws Exception;
	
}
