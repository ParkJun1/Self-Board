package org.mstory.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.mstory.bbs.mapper.ReplyMapper;
import org.mstory.bbs.vo.ReplyVO;
import org.springframework.stereotype.Service;

@Service("ReplyService")
public class ReplyServiceImple {
	
	@Inject 
	ReplyMapper mapper;

	public List<ReplyVO> getReplyList(Integer bno) throws Exception {
		System.out.println("getReplyList()....................");
		return mapper.replyList(bno);
	}

	public void insertReply(ReplyVO reVO) throws Exception {
		mapper.insertReply(reVO);
	}

	public ReplyVO getReply(Integer rno) throws Exception {
		return mapper.getReply(rno);
	}

	public void updateReply(ReplyVO reVO) throws Exception {
		mapper.updateReply(reVO);
	}

	public void deleteReply(Integer rno) throws Exception {
		mapper.deleteReply(rno);
	}
	
	
}
