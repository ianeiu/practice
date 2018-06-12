package fix;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.wm.utils.file.ExcelUtil;

import fix.vo.ExcelTestVO;

public class ExcelTest {

	@Test
	public void getData(){
		File file = new File("G:\\20171120data.xls");
		//File file = new File("G:\\ExcelTest20171212.xlsx");
		List<Map<String,String>> dataList = null;
		try {
			dataList = ExcelUtil.getDataFromExecl2003(new FileInputStream(file));
			//dataList = ExcelUtil.getDataFromExecl2007(new FileInputStream(file));
		} catch (Exception e) {
			System.out.println("出错了啊啊啊");
			e.printStackTrace();
		}
		if(null!=dataList&&!dataList.isEmpty()){
			int i = 1;
			for(Map<String,String> map :dataList){
				System.out.println("读取dataList的第"+i+"个map值");
				for (Map.Entry<String, String> entry : map.entrySet()) {
					System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
				}
				i++;
			}
		}
	}
	
	@Test
	public void getData2(){
		//String attr[] = {"abc","cde","efg","ghi","ijk"};
		String attr[] = {"abc","ghi","ijk"};
		List<ExcelTestVO> list = new ArrayList<ExcelTestVO>();
		File file = new File("G:\\20171120data.xls");
		//File file = new File("G:\\ExcelTest20171212.xlsx");
		try {
			list = ExcelUtil.excel2003ImportBoty(ExcelTestVO.class, new FileInputStream(file), 1, 2, attr);
			//dataList = ExcelUtil.getDataFromExecl2007(new FileInputStream(file));
		} catch (Exception e) {
			System.out.println("出错了啊啊啊");
			e.printStackTrace();
		}
		for(ExcelTestVO vo:list){
			System.out.println(vo);
		}
	}
	
}
