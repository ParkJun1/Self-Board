package org.mstory.bbs.service;

import java.util.List;

import org.mstory.bbs.common.Criteria;
import org.mstory.bbs.vo.BbsVO;

public interface BbsService {
	
	public BbsVO getTest(); //���� �׽�Ʈ 
	
	public void tranTest(String a, String b) throws Exception; //Ʈ������ �׽�Ʈ
	
	public List<BbsVO> getBbsList(Criteria cri) throws Exception; //�Խ��� ��ȸ
	
	public List<BbsVO> getBbsSearchList(Criteria cri) throws Exception; //�˻� �Խ��� ��ȸ
		
	public void insertBbs(BbsVO bbsVO) throws Exception; //C
	
	public BbsVO getBbs(Integer bno) throws Exception; //R
	
	public BbsVO getUpdateBbs(Integer bno) throws Exception; //������ ������ �ٽ� ��ȸ�Ҷ� ��ȸ���� �ö��� �ʵ���...
	
	public void updateBbs(BbsVO bbsVO) throws Exception; //U
	
	public void deleteBbs(Integer bno) throws Exception; //D

}
