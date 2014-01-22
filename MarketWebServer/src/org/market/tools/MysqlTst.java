package org.market.tools;
import org.market.controlmysql.*;
import org.market.types.*;
public class MysqlTst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientInfo test = new ClientInfo();
		ClientType a = test.viewIndividualInfo("customer1");
		System.out.println("password:"+a.getPassword());
	}

}
