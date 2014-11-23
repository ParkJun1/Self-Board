package org.mstory.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mstory.bbs.vo.ReplyVO;

public interface ReplyMapper {
	
	@Select("select " 
			  + "r.rno, r.bno, r.replyer, r.reply, r.regdate, r.moddate, ceil(sysdate-r.regdate) lately " 
			  + "from " 
			  + "tbl_reply r, tbl_book b " 
			  + "where r.bno = b.bno and b.bno = #{bno}"
			  + "order by bno desc")
	public List<ReplyVO> replyList(Integer bno);
		
	@Insert("insert into tbl_reply(rno, bno, replyer, reply) "
			+ "values(seq_rno.nextval, #{bno}, #{replyer}, #{reply})")
	public void insertReply(ReplyVO vo);
	
	@Select("select " 
			+ "rno, replyer, reply, regdate, moddate " 
			+ "from " 
			+ "tbl_reply " 
			+ "where rno = #{rno} ")
	public ReplyVO getReply(Integer rno);
	
	@Update("update tbl_reply " 
			+ "set reply = #{reply}, regdate = sysdate, moddate = sysdate " 
			+ "where rno = #{rno}")
	public void updateReply(ReplyVO vo);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	public void deleteReply(Integer rno);
}
