package core.hiberante;

import org.hibernate.boot.archive.internal.FileInputStreamAccess;
import org.hibernate.boot.archive.scan.internal.ClassDescriptorImpl;
import org.hibernate.boot.archive.scan.internal.ScanResultCollector;
import org.hibernate.boot.archive.scan.spi.*;

import java.io.File;


public class SingleClassScanner implements Scanner {

    private Class<?> entityClass;

    public SingleClassScanner(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public ScanResult scan(ScanEnvironment environment, ScanOptions options, ScanParameters params) {

        String fileName = entityClass.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("%20", " ")
                + File.separator
                + entityClass.getCanonicalName().replace(".", File.separator)
                + ".class";

        File f = new File(fileName);

        final ScanResultCollector collector = new ScanResultCollector( environment, options, params );

        FileInputStreamAccess stm = new FileInputStreamAccess(f.getAbsolutePath(), f);
        collector.handleClass(new ClassDescriptorImpl(entityClass.getCanonicalName(), ClassDescriptor.Categorization.MODEL, stm), false);

        return collector.toScanResult();
    }

}
