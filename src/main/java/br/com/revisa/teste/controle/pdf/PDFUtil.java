package br.com.revisa.teste.controle.pdf;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {
	
	public CartaConcessao extrairInformacoes(byte[] pdf) {
		
		PDDocument document = null;
		PDFTextStripper stripper = null;
		Scanner scanner = null;
		
		try {
			
			document = PDDocument.load(pdf);
			
			stripper = new PDFTextStripper();
			stripper.setSortByPosition(true);
			
			String docPdf = stripper.getText(document);
			
			scanner = new Scanner(docPdf).useDelimiter("\n");
			
			CartaConcessao carta = new CartaConcessao();
			
			while(scanner.hasNext()) {
				
				String linha = scanner.next().trim();
				
				String nome = extrairDadoNome(linha);
				if(nome != null)
					carta.setNome(linha);
				
				LocalDate data = extrairDadoDataConcessao(linha);
				if(data != null)
					carta.setData(data);
				
				String[] dadosContribuicao = extrairDadosContribuicao(linha);
				if(dadosContribuicao != null) {
					Contribuicao c = new Contribuicao();
					c.setSequencia(dadosContribuicao[0]);
					c.setData(YearMonth.parse(dadosContribuicao[1], formatador("MM/yyyy")));
					c.setSalario(new BigDecimal(dadosContribuicao[2]));
					c.setIndice(Float.parseFloat(dadosContribuicao[3]));
					c.setSalarioCorrigido(new BigDecimal(dadosContribuicao[4]));
					carta.addContribuicao(c);
				}
				
			}
		
			document.close();
			
			return carta;
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar extrair informações do arquivo!");
			throw new RuntimeException(ex);
			
		}finally{
			scanner.close();
		}
		
	}
	
	
	private String extrairDadoNome(String linha) {
		
		if(linha.contains("Nome:"))
			return linha.split(":")[1].trim();
			
		return null;
		
	}
	
	private LocalDate extrairDadoDataConcessao(String linha) {
		
		if(linha.contains("Data de Concessão do Benefício:")) {
			String data = linha.split(":")[1].trim();
			return LocalDate.parse(data, formatador("dd/MM/yyyy"));
		}
		
		return null;
		
	}
	
	private String[] extrairDadosContribuicao(String linha) {
		
		String regex = "\\d{3}\s\\d{2}/\\d{4}\s\\d+(\\.\\d{3})*,\\d{2}\s\\d+,\\d{4}\s\\d+(\\.\\d{3})*,\\d{2}(\s.)?";
		
		if(linha.matches(regex)) {
			
			String[] partes = linha.split("\s");
			partes[2] = partes[2].replace(".", "").replace(",", ".");
			partes[3] = partes[3].replace(".", "").replace(",", ".");
			partes[4] = partes[4].replace(".", "").replace(",", ".");
			
			return partes;
			
		}
		
		return null;
		
	}
	
	private DateTimeFormatter formatador(String pattern) {
		return DateTimeFormatter.ofPattern(pattern);
	}
	
}
