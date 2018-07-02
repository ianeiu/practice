package com.wm.demo.use;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportDownload{
	private String filePath;
	private String fileName;
	
	
	// 导出功能：
	public void doOrderExport(List<OrderVO> list) throws IOException {
		InputStream fileInputStream = new FileInputStream(
				new File(this.getClass().getResource("").getPath() + "file/提数系统-工单统计导出.xls"));

		HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = null;
		for (int i = 0; i < list.size(); i++) {
			OrderVO vo = list.get(i);
			row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(vo.getId());
			/*row.createCell(1).setCellValue(vo.getTaskname());
			row.createCell(2).setCellValue(vo.getStartTime());
			// row.createCell(3).setCellValue(vo.getFinishTime());
			row.createCell(3).setCellValue(vo.getCreateer());
			row.createCell(4).setCellValue(vo.getDataDepartment());
			row.createCell(5).setCellValue(vo.getIfUrgency());
			row.createCell(6).setCellValue(vo.getMgLevel());
			row.createCell(7).setCellValue(vo.getDateUse());
			row.createCell(8).setCellValue(vo.getType());
			row.createCell(9).setCellValue(vo.getDealer());
			row.createCell(10).setCellValue(vo.getFhdealtr());*/
		}

		String filename = "提数系统-工单统计导出.xlsx";
		filename = new String(filename.getBytes(), "ISO-8859-1");
		/*ServletActionContext.getResponse().reset();
		ServletActionContext.getResponse().setContentType("application/ms-excel");
		ServletActionContext.getResponse().addHeader("Content-Disposition",
				"attachment; filename=\"" + filename + "\"");
		wb.write(ServletActionContext.getResponse().getOutputStream());
		ServletActionContext.getResponse().getOutputStream().flush();*/

	}

	// 下载
	public void download() throws IOException {

		String fpath = URLDecoder.decode(filePath, "UTF-8");
		String fname = URLDecoder.decode(fileName, "UTF-8");

		File file = new File(fpath);
		FileInputStream in = null;
		/*HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			in = new FileInputStream(file);
			// 设置输出的格式
			response.reset();
			response.setContentType("bin");
			// response.addHeader("Content-Disposition", "attachment;
			// filename=\"" + file.getName() + "\"");

			String type = request.getHeader("User-Agent").toUpperCase();

			if (request.getHeader("User-Agent").toUpperCase().indexOf("msie") > 0) {
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + URLEncoder.encode(fname, "UTF-8") + "\"");
			} else {
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + new String(fname.getBytes(), "ISO-8859-1") + "\"");
			}
			// 循环取出流中的数据
			byte[] b = new byte[1024];
			int len;
			try {
				while ((len = in.read(b)) > 0)
					response.getOutputStream().write(b, 0, len);
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			response.setCharacterEncoding("UTF-8");// 设置编码
			response.setContentType("text/html");// 服务器响应类型
			PrintWriter pw = response.getWriter();
			pw.write("<script language='javascript'>alert('文件不存在');history.go(-1);</script>");
			pw.close();
		}*/
	}

	// 文件不存在
	public void nullDataTip() throws IOException {
		/*HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");// 设置编码
		response.setContentType("text/html");// 服务器响应类型
		PrintWriter pw = response.getWriter();
		pw.write("<script language='javascript'>alert('数据为空')</script>");
		pw.close();*/
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}

class OrderVO{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

