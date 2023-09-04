package com.semi_5makase.common.model.vo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	// 원본파일 전달받아서 파일명 수정작업 후 파일을 반환시켜주는 메소드
	@Override
	public File rename(File originFile) {

		// 원본파일명
		String originName = originFile.getName();
		
		// 1. 파일 업로드 시간 (년월일시분초 형태)
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 2. 5자리 랜덤값
		int ranNum = (int)(Math.random() * 90000 + 10000); 
		
		// 3. 원본파일 확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext;
		
		return new File(originFile.getParent(), changeName); // 원본의 디렉토리를 알아낸 후 변경된 이름으로 저장하는 메소드
	}
	
	
	
}