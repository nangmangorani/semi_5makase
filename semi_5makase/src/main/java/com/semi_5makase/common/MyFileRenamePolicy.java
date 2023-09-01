package com.semi_5makase.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		String originName = originFile.getName();

		// => 수정파일명("2023081712253012345.jpg")
		//			   파일업로드시간(년월일시분초) + 5자리랜덤값 (10000~99999) + 원본파일확장자
		
		// 1. 파일 업로드 시간 (년월일시분초 형태) (String currentTime)
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // "20230817122955"
		
		// 2. 5자리 랜덤값 (int ranNum)
		int ranNum = (int)(Math.random() * 90000 + 10000); // 12311
		
		// 3. 원본파일의 확장자 (String ext)
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext;
		
		// 경로.. parant
		return new File(originFile.getParent(), changeName);
	}

}
