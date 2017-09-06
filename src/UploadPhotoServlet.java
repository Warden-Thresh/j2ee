import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadPhotoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String filename = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//设置上传文件的大小限制为1M；
			factory.setSizeThreshold(1024*1024);
			
			List items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					//根据时间戳创建文件
					filename = System.currentTimeMillis()+".jpg";
					String photoFolder ="d:\\workspace\\j2ee\\web\\uploaded";
					File file = new File(photoFolder,filename);
					file.getParentFile().mkdirs();
					
					//通过item.getInputStream()获取浏览器上传的文件的输入流 ；
					InputStream inputStream = item.getInputStream();
					
					//复制文件
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					byte b[] = new byte[1024*1024];
					int length =0;
					while (-1 != (length = inputStream.read(b))) {
						fileOutputStream.write(b, 0, length);	
					}
					fileOutputStream.close();
				}else {
					System.out.println(item.getFieldName());
					String value = item.getString();
					value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
					System.out.println(value);
				}
			}
			String html = "<img width ='200' height='150' src='uploaded/%s' />";
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			printWriter.format(html, filename);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
