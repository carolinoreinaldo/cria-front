package constantes;

import java.io.File;

import enums.JavaScript;

public class Constantes {

	public static final String BAR = String.valueOf(File.separatorChar);
	public static final String CAMINHO_PROJETO = new File("").getAbsolutePath() + BAR;
	public static final String CAMINHO_DESTINO_JS = new File("").getAbsolutePath() + BAR + "js" + BAR;
	public static final String CAMINHO_DESTINO_JQUERY = new File("").getAbsolutePath() + BAR + "js" + BAR + JavaScript.JQUERY;
	public static final String CAMINHO_DESTINO_LODASH = new File("").getAbsolutePath() + BAR + "js" + BAR + JavaScript.JQUERY;
}