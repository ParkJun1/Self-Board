package org.mstory.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.mstory.bbs.common.Criteria;
import org.mstory.bbs.mapper.BbsMapper;
import org.mstory.bbs.vo.BbsVO;
import org.springframework.stereotype.Service;

@Service("BbsService")
public class BbsServiceImple implements BbsService {

	@Inject
	BbsMapper mapper;
	
	@Override
	public BbsVO getTest() {
		// TODO Auto-generated method stub
		System.out.println("test~~~~~~~~~~~");
		return mapper.getBookTest();
	}

	@Override
	public void tranTest(String a, String b) throws Exception {
		// TODO Auto-generated method stub
		mapper.test1(a);
		mapper.test2(b);
	}

	@Override
	public List<BbsVO> getBbsList(Criteria cri) throws Exception {
		System.out.println("getBbsList()...............service");
		return mapper.readList(cri);
	}
	
	@Override
	public List<BbsVO> getBbsSearchList(Criteria cri) throws Exception {
		System.out.println("getBbsSearchList()..............service");
		return mapper.searchList(cri);
	}

	@Override
	public void insertBbs(BbsVO bbsVO) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(bbsVO);
		
		for (String filename : bbsVO.getFileList()) {
			bbsVO.setFilename(filename); 
			System.out.println("service : " + bbsVO);
			//그래서 여기서 bbsVO를 찍어주면 bno가 셋팅된것을 확인 할 수 있다.
			mapper.fileInsert(bbsVO);
		}
	}

	@Override
	public BbsVO getBbs(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		mapper.viewCntUpdate(bno);
		BbsVO bbsVO = mapper.read(bno);
		bbsVO.setReplycnt(mapper.cntReply(bno));
		
		List<String> tempList = mapper.fileRead(bno);
		String[] fileList = new String[tempList.size()];

		bbsVO.setFileList(tempList.toArray(fileList));
		
		System.out.println("service : " + bbsVO);
		
		return bbsVO;
	}

	@Override
	public BbsVO getUpdateBbs(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public void updateBbs(BbsVO bbsVO) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(bbsVO);
	}

	@Override
	public void deleteBbs(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(bno);
	}



}
