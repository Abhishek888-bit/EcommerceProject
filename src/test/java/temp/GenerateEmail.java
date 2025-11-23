package temp;

import java.util.Date;

public class GenerateEmail {

	public static void main(String[] args) {

		Date date = new Date();

		String stringdate = date.toString();

		String datewithoutspace = stringdate.replaceAll(" ","");
		String datewithoutcolon = datewithoutspace.replaceAll(":","");

		String email = datewithoutcolon + "@gmail.com";
		System.out.println(email);

	}

}
