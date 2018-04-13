package criadoresfisicos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@SuppressWarnings("unused")
public class CopiaPasta {

	public void copiaPasta(File origem, File destino) throws IOException{
		copy(origem, destino, true);
		copyAll(origem, destino, true);
	}
	
	public void copy(File origem, File destino, boolean overwrite) throws IOException {
        if (destino.exists() && !overwrite) {
            return;
        }
        Files.copy(Paths.get(origem.getAbsolutePath()), Paths.get(destino.getAbsolutePath()),StandardCopyOption.REPLACE_EXISTING);
    }
	
	/**
     * Copia todos os arquivos que tenham uma determinada extensão de uma pasta de origem para outra de destino.
     * @param origem - Diretório onde estão os arquivos a serem copiados
     * @param destino - Diretório onde os arquivos serão copiados
     * @param extensao - <i>String</i> Extensão do arquivo que deve ser copiada. Você pode inserir a extensão no formato: ".doc" ou "doc" (por exemplo)
     * @param overwrite - Confirmação para sobrescrever os arquivos
     * @throws IOException, UnsupportedOperationException
     */
	private void copyAll(File origem, File destino, String extensao, boolean overwrite) throws IOException, UnsupportedOperationException {
        if (!destino.exists()) {
            destino.mkdir();
        }
        if (!origem.isDirectory()) {
            throw new UnsupportedOperationException("Origem deve ser um diretório");
        }
        if (!destino.isDirectory()) {
            throw new UnsupportedOperationException("Destino deve ser um diretório");
        }
        File[] files = origem.listFiles();
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory()) {
                copyAll(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
            } else {
                if (files[i].getName().endsWith(extensao)) {
                    copy(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
                }
            }
        }
    }
    /**
     * Copia todos os arquivos de dentro de uma pasta para outra.
     * @param origem - Diretório onde estão os arquivos a serem copiados
     * @param destino - Diretório onde os arquivos serão copiados
     * @param overwrite - Confirmação para sobrescrever os arquivos
     * @throws IOException, UnsupportedOperationException
     */
    private void copyAll(File origem, File destino, boolean overwrite) throws IOException, UnsupportedOperationException {
        if (!destino.exists()) {
            destino.mkdir();
        }
        if (!origem.isDirectory()) {
            throw new UnsupportedOperationException("Origem deve ser um diretório");
        }
        if (!destino.isDirectory()) {
            throw new UnsupportedOperationException("Destino deve ser um diretório");
        }
        File[] files = origem.listFiles();
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory()) {
                copyAll(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
            } else {
                System.out.println("Copiando arquivo: " + files[i].getName());
                copy(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
            }
        }
    }
}
