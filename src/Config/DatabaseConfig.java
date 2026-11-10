package Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class DatabaseConfig {
    private static final String DATABASE_PATH =
            System.getProperty("oasis.db.path", "data/oasis-spa.db");

    private DatabaseConfig() {
    }

    public static String getJdbcUrl() {
        Path databasePath = Path.of(DATABASE_PATH).toAbsolutePath();
        try {
            Files.createDirectories(databasePath.getParent());
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo crear la carpeta de la base de datos.", e);
        }
        return "jdbc:sqlite:" + databasePath;
    }
}
