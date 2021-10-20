package svc;

import static db.Jdbcutil.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import vo.Cart;
import vo.Product;

public class BasketCartAddService {

	/*BaskeyCartAddAction*/
	public Product geteCartBaskey(int serial_code) throws Exception {
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);

		Product product = productDAO.selectBaskeyCart(serial_code);

		close(con);

		return product;
	}

	/* BaskeyCartAddAction */
	public void addCart(HttpServletRequest request, Product basketCart) throws Exception {

		HttpSession session = request.getSession();

		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		if (cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}

		boolean isNewCart = true;

		for (int i = 0; i < cartList.size(); i++) {
			if (basketCart.getName().equals(cartList.get(i).getName())) {
				isNewCart = false;
				break;
			}
		}

		if (isNewCart == true) {
			Cart cart = new Cart();

			cart.setSerial_code(basketCart.getSerial_code());
			cart.setName(basketCart.getName());
			cart.setCount(basketCart.getCount());
			cart.setPrice(basketCart.getPrice());
			cart.setKinds(basketCart.getChoice());

			cartList.add(cart);
		}
	}
}
