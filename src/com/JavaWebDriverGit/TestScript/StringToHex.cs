/*
 * Created by SharpDevelop.
 * User: guptap
 * Date: 6/12/2017
 * Time: 10:23 AM
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using OpenQA.Selenium;
namespace Converter
{
	class StringToHexa
	{
		//the expected value after conversion
		static string expectedHexaValueOfheading = "#8AAB7";
		
		
		//declare the variables as static
		//to access the current value
		//in dif methods directly
		static byte rColor = 0;
		static byte gcolor = 0;
		static byte bColor = 0;
			
		//struct to set the value of R, G and B
		public struct RGB
		{
			private byte _r;
			private byte _g;
			private byte _b;

			public RGB(byte r, byte g, byte b)
			{
				this._r = r;
				this._g = g;
				this._b = b;
			}

			public byte R {
				get { return this._r; }
				set { this._r = value; }
			}

			public byte G {
				get { return this._g; }
				set { this._g = value; }
			}

			public byte B {
				get { return this._b; }
				set { this._b = value; }
			}

			public bool Equals(RGB rgb)
			{
				return (this.R == rgb.R) && (this.G == rgb.G) && (this.B == rgb.B);
			}
		}
	
		//maths algo to convert dec to hexa
		private static string DecimalToHexadecimal(int dec)
		{
			if (dec <= 0)
				return "00";

			int hex = dec;
			string hexStr = string.Empty;

			while (dec > 0) {
				hex = dec % 16;

				if (hex < 10)
					hexStr = hexStr.Insert(0, Convert.ToChar(hex + 48).ToString());
				else
					hexStr = hexStr.Insert(0, Convert.ToChar(hex + 55).ToString());

				dec /= 16;
			}

			return hexStr;
		}

	
		//convert rgb to hex using the method DecimalToHexadecimal
		public static string RGBToHexadecimal(RGB rgb)
		{
			string rs = DecimalToHexadecimal(rgb.R);
			string gs = DecimalToHexadecimal(rgb.G);
			string bs = DecimalToHexadecimal(rgb.B);

			return '#' + rs + gs + bs;
		}
		//Split the RGB value and set the value of rcolor,gcolor,bcolor
		public void splitAndSet(string decimalValueRGB)
		{
			string[] valuesExtractOpenBracket = decimalValueRGB.Split('(');
			Console.WriteLine(valuesExtractOpenBracket[0] + " " + valuesExtractOpenBracket[1]);
	
			string[] valuesExtractEndBracket = valuesExtractOpenBracket[1].Split(')');
			Console.WriteLine(valuesExtractEndBracket[0] + " " + valuesExtractEndBracket[1]);
	
			string[] values = valuesExtractEndBracket[0].Split(',');

			for (int i = 0; i < values.Length; i++) {
				values[i] = values[i].Trim();
			}
			Console.WriteLine("String values in split function before Convert: " + values[0] + " "
			+ values[1] + " "
			+ values[2] + " ");

			StringToHexa.rColor = Convert.ToByte(values[0]);
			StringToHexa.gcolor = Convert.ToByte(values[1]);
			StringToHexa.bColor = Convert.ToByte(values[2]);

			Console.WriteLine("Byte values in split function before Convert: " + StringToHexa.rColor + " "
			+ StringToHexa.gcolor + " "
			+ StringToHexa.bColor + " ");
		}
		
		public static void Main(string[] args)
		{
			Console.WriteLine("Selenium Test Project - 1");
			
			// TODO: Implement Functionality Here
			IWebDriver driver = new OpenQA.Selenium.Chrome.ChromeDriver("C:\\Users\\guptap\\Documents\\SharpDevelop Projects\\Test\\Selenium1");

			
//CHROME : GET TEXT PROPERTIES
			driver.Navigate().GoToUrl("https://www.sqs.com/en/index.php");
			//System.Threading.Thread.Sleep(10000);
			
			
			//working with css
			IWebElement wElement = driver.FindElement(By.CssSelector(".col-xs-8.teaser-text>h2"));
			String wElementColorRGB = wElement.GetCssValue("color");
			Console.WriteLine("RGB value of the text is :" + wElementColorRGB);
	
			//split and set
			StringToHexa objClass = new StringToHexa();
			objClass.splitAndSet(wElementColorRGB);
	
//RGB to HEX using System.Drawing.Color class
			//String s = StringToHexa.HexConverter(wElementColorRGB);


//RGB to HEX using algorithm
			//Color myColor = Color.FromArgb(255, 181, 178);			
			//String hex = myColor.R.ToString("X2") + myColor.G.ToString("X2") + myColor.B.ToString("X2");
			
			
//RGB to HEX using struct
			RGB data = new RGB(rColor, gcolor, bColor);
			String value = RGBToHexadecimal(data);
	
			Console.WriteLine("The text color(RGB) of sub heading Transforming The World Through Quality is: " 
			                  + value);
			
			if(expectedHexaValueOfheading==value)
			{
				Console.WriteLine("expected value achieved");
			}
			Console.ReadLine();
			//driver.Close();
			//driver.Quit();   css : .col-xs-8.teaser-text>h2 //xpath not working : //div[class='col-xs-8 teaser-text']/h2
		}
	}

}