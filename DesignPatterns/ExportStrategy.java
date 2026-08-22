interface ExportStrategy {
    void export(String data);
}

class PdfExport implements ExportStrategy{
    @Override
    public void export(String data){
        System.out.println("Exporting report to a PDF document... Data: " + data);
    }
}

class CsvExport implements ExportStrategy{
    @Override
    public void export(String data){
        System.out.println("Exporting report to a CSV spreadsheet... Data: " + data);
    }
}

class JsonExport implements ExportStrategy{
    @Override
    public void export(String data){
        System.out.println("Exporting report to a JSON object... Data: " + data);
    }
}

class ReportContext{
    private ExportStrategy exportStrategy;

    public void setExportStrategy(ExportStrategy exportStrategy){
        this.exportStrategy = exportStrategy;
    }

    public void generateReport(String data){
        if(exportStrategy == null){
            System.out.println("No export strategy");
        }
        exportStrategy.export(data);
    }
}

class MainRun12{
    static void main() {
        ReportContext reportContext = new ReportContext();

        reportContext.setExportStrategy(new JsonExport());
        reportContext.generateReport("Test Test");
    }
}


