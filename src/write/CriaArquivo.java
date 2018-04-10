package write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriaArquivo {

	final private static String DIRETORIO_ATUAL = new File(".").getAbsolutePath();
	
	public void criaDiretorioBase(String nomeProjeto) {
		final File diretorio = new File(DIRETORIO_ATUAL + "/" + nomeProjeto);
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
	}
	
	public void criaArquivoFisico(final String nomeAquivo, final String conteudoArquivo, final String extensao) throws IOException {
		final String path = DIRETORIO_ATUAL + "/" + nomeAquivo + "/" + nomeAquivo + "." + extensao;
		escreverPorPrimeiro(conteudoArquivo, path);
	}
	
	public void escreverPorPrimeiro(String conteudo,String url) {
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