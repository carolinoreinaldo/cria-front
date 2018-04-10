package criadoresfisicos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriaArquivo {

	final private static String DIRETORIO_ATUAL = new File("").getAbsolutePath();
	final private static String BAR = String.valueOf(File.separatorChar);
	
	public void criarPastas(String nomeProjeto) {
		criarPasta(DIRETORIO_ATUAL + BAR + nomeProjeto);
		criarPasta(DIRETORIO_ATUAL + BAR + nomeProjeto + BAR + "js");
		criarPasta(DIRETORIO_ATUAL + BAR + nomeProjeto + BAR + "css");
	}
	
	public void criarPasta(String caminhoPasta){
		final File pasta = new File(caminhoPasta);
		if(!pasta.exists()) {
			pasta.mkdir();
		}
	}
	
	public void criaArquivoFisico(final String nomeAquivo, final String conteudoArquivo, final String extensao) throws IOException {
		String path = DIRETORIO_ATUAL + BAR + nomeAquivo + BAR + nomeAquivo + "." + extensao;
		gravarEmArquivo(conteudoArquivo, path);
	}
	
	public void gravarEmArquivo(String conteudo,String url) {
        try {
            File file = new File(url);
            if (!file.exists())
                file.createNewFile();

            FileWriter fileWriter = new FileWriter(file, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(conteudo);

            printWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}