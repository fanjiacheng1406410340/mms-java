/**
 * com.ctc.ctcoss.test.TestHttp
 */
package com.dahantc.example;

import java.util.UUID;

import com.dahantc.mmshttp.RespInfo;
import com.dahantc.mmshttp.utils.MMSHttpClientUtil;

/**
 * 测试彩信HTTP接口
 * 
 * @author 8512
 *
 */
public class MMSHttpExample {

	public static void main(String[] args) {
		//服务端地址，默认可不设置
		 MMSHttpClientUtil.setServerUrl("http://mms.3tong.net/http/mms");

		String account = "dh12312";// 用户名
		String password = "ifjV34L9";// 密码(明文)
		String title = "测试彩信";// 彩信主题
		String path = "./resource/mms.zip";// 彩信zip包路径
		String msgid = UUID.randomUUID().toString().replace("-", "");// 彩信唯一标识
		String phones = "13628691654";// 发送手机号，多个英文逗号分隔
		String subCode = "002";// 扩展码

		RespInfo _respInfo = null;
		System.out.println("-------------------账户连接测试-------------------");
		_respInfo = MMSHttpClientUtil.bind(account, password);
		if (MMSHttpClientUtil.whetherSuccess(_respInfo)) {
			System.out.println("账户连接测试成功，响应信息：" + _respInfo.getRespVal());
		} else {
			System.out.println("账户连接测试失败，响应信息：" + _respInfo.getRespVal()
					+ "错误码：" + _respInfo.getHttpStatus());
		}

		System.out.println("-------------------发送彩信-------------------");
		_respInfo = MMSHttpClientUtil.sendMms(account, password, msgid, phones,
				title, path, subCode);

		if (MMSHttpClientUtil.whetherSuccess(_respInfo)) {
			System.out.println("发送彩信成功，响应信息：" + _respInfo.getRespVal());
		} else {
			System.out.println("发送彩信失败，响应信息：" + _respInfo.getRespVal() + "错误码："
					+ _respInfo.getHttpStatus());
		}

		System.out.println("-------------------获取状态报告-------------------");
		_respInfo = MMSHttpClientUtil.getReport(account, password);
		if (MMSHttpClientUtil.whetherSuccess(_respInfo)) {
			System.out.println("获取状态报告成功，响应信息：" + _respInfo.getRespVal());
		} else {
			System.out.println("获取状态报告失败，响应信息：" + _respInfo.getRespVal()
					+ "错误码：" + _respInfo.getHttpStatus());
		}

		System.out.println("-------------------获取上行-------------------");
		_respInfo = MMSHttpClientUtil.getMms(account, password);
		if (MMSHttpClientUtil.whetherSuccess(_respInfo)) {
			System.out.println("获取上行成功，响应信息：" + _respInfo.getRespVal());
		} else {
			System.out.println("获取上行失败，响应信息：" + _respInfo.getRespVal() + "错误码："
					+ _respInfo.getHttpStatus());
		}
	}
}
