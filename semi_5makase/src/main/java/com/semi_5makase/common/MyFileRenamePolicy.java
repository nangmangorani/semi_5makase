package com.semi_5makase.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		
		
		String originName = originFile.getName();
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // "20230817122955"
		int ranNum = (int)(Math.random() *90000 + 10000); // 56132
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = currentTime + ranNum + ext;
		
		return new File(originFile.getParent(), changeName);  // 원본의 디렉토리를 알아낸 후 변경된 이름으로 저장하는 매소드

	}

	
}
