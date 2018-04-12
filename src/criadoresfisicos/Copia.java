package criadoresfisicos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@SuppressWarnings("resource")
public class Copia {

	public void copyFile(File source, File destination) throws IOException {
        if (destination.exists())
            destination.delete();
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
       }
   }
}