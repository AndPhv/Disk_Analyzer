import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Path;

public class Analyzer {
    public Map<String, Long> calculateDirectorySize(Path path) {
        try {
            HashMap<String, Long> sizes = new HashMap<>();
            Files.walkFileTree(
                    path,
                    new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            return super.visitFile(file, attrs);
                        }

                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                            return super.visitFileFailed(file, exc);
                        }
                    }
            );
            return sizes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}