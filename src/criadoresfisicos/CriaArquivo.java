package criadoresfisicos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import dto.ArquivoDto;
import dto.OpcoesDto;


public abstract class CriaArquivo {

	protected ArquivoDto arquivo;
	protected OpcoesDto opcoes;
	
	public CriaArquivo(ArquivoDto arquivo, OpcoesDto opcoes) {
		this.arquivo = arquivo;
		this.opcoes = opcoes;
	}
	
	public void gravarEmArquivo() {
        try {
            File file = new File(recuperarUrl());
            if (!file.exists())
                file.createNewFile();

            FileWriter fileWriter = new FileWriter(file, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(arquivo.getConteudoArquivo());

            printWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	protected abstract String recuperarUrl();
}