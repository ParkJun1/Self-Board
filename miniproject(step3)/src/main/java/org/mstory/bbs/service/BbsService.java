package org.mstory.bbs.service;

import java.util.List;

import org.mstory.bbs.common.Criteria;
import org.mstory.bbs.vo.BbsVO;

public interface BbsService {
	
	public BbsVO getTest(); //서비스 테스트 
	
	public void tranTest(String a, String b) throws Exception; //트랜젝션 테스트
	
	public List<BbsVO> getBbsList(Criteria cri) throws Exception; //게시판 조회
	
	public List<BbsVO> getBbsSearchList(Criteria cri) throws Exception; //검색 게시판 조회
		
	public void insertBbs(BbsVO bbsVO) throws Exception; //C
	
	public BbsVO getBbs(Integer bno) throws Exception; //R
	
	public BbsVO getUpdateBbs(Integer bno) throws Exception; //수정할 도서를 다시 조회할때 조회수가 올라가지 않도록...
	
	public void updateBbs(BbsVO bbsVO) throws Exception; //U
	
	public void deleteBbs(Integer bno) throws Exception; //D

}
