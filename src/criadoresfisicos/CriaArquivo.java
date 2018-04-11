package criadoresfisicos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import dto.OpcoesDto;

public abstract class CriaArquivo {

	protected static final String DIRETORIO_ATUAL = new File("").getAbsolutePath();
	protected static final String BAR = String.valueOf(File.separatorChar);
	
	public void gravarEmArquivo(String conteudo, OpcoesDto opcoes) {
        try {
            File file = new File(recuperarUrl(opcoes.getNomeProjeto()));
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

	public abstract String recuperarUrl(String nomeArquivo);
}