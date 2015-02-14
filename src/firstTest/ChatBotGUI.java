/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ChatBotGUI extends javax.swing.JFrame{
    
    //public String POStags = 
    public String historyText = ("_program: greetings user");
    public String inputUser = ("no input");
    public String verboseOutput = "";
    /**
     * Creates new form ChatBotGUI
     */
    public ChatBotGUI() {
        
        initComponents();
        inputText.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputText = new javax.swing.JTextField();
        chatButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        chatScroll = new javax.swing.JScrollPane();
        chatText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("test chatbot");

        inputText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputTextKeyPressed(evt);
            }
        });

        chatButton.setText("chat");
        chatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatButtonActionPerformed(evt);
            }
        });

        clearButton.setText("clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        chatText.setEditable(false);
        chatText.setColumns(20);
        chatText.setRows(5);
        chatText.setText("_program: greetings user");
        chatScroll.setViewportView(chatText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputText))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatButtonActionPerformed
        // TODO add your handling code here:
        recordUser();
        try {
            programChat();
        } catch (IOException ex) {
            Logger.getLogger(ChatBotGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_chatButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        chatText.setText("_program: greetings user");
        inputText.setText(" ");
        historyText = ("_program: greetings user");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void inputTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextKeyPressed
        // TODO add your handling code here:
        int id = evt.getKeyCode();
        //inputText.setText("id of key pressedd: " + id);
        if (id == KeyEvent.VK_ENTER) {
            recordUser();
            try {
                programChat();
            } catch (IOException ex) {
                Logger.getLogger(ChatBotGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_inputTextKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatBotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatBotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatBotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatBotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatBotGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chatButton;
    private javax.swing.JScrollPane chatScroll;
    private javax.swing.JTextArea chatText;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField inputText;
    // End of variables declaration//GEN-END:variables

    private void recordUser() {
        inputUser = inputText.getText(); //get text from user
        historyText = historyText + "\n_user: " + inputUser;
        chatText.setText(historyText); // echo text to text box
        inputText.setText("");    //clear text entry field 
    }

    private void programChat() throws IOException {
        String loopOutput = "";
        String loopOutputVerbose = "";
        POSModel model = new POSModelLoader().load(new File("en-pos-maxent.bin"));
        PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
        POSTaggerME tagger = new POSTaggerME(model);

        String input = inputUser;
        ObjectStream<String> lineStream =
            new PlainTextByLineStream(new StringReader(input));

        perfMon.start();
        String line;
        while ((line = lineStream.read()) != null) {

            String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line);
            String[] tags = tagger.tag(whitespaceTokenizerLine);
            
            POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
            
            loopOutput = loopOutput + sample.toString();
            
            perfMon.incrementCounter();
            int count = tags.length;
            
            for(int i=0;i<count;i++){
                verboseOutput = verboseOutput + whitespaceTokenizerLine[i] + " (" + tagLookup(tags[i]) + ")\n";
            }
        }
        
    
        
        
        historyText = historyText + "\n_program: " + verboseOutput;
       
        verboseOutput = "";
        chatText.setText(historyText); // echo text to text box
        inputText.setText("");    //clear text entry field 
    }

   

    private String tagLookup(String inputTag) {
        //To change body of generated methods, choose Tools | Templates.
        
        if(inputTag.equals("CC")) {return "Coordinating conjunction";}
        else if (inputTag.equals("CD")) {return "Cardinal number";}
        else if (inputTag.equals("DT")) {return "Determiner";}
        else if (inputTag.equals("EX")) {return "Existential there";}
        else if (inputTag.equals("FW")) {return "Foreign word";}
        else if (inputTag.equals("IN")) {return "Preposition or subordinating conjunction";}
        else if (inputTag.equals("JJ")) {return "Adjective";}
        else if (inputTag.equals("JJR")) {return "Adjective, comparative";}
        else if (inputTag.equals("JJS")) {return "Adjective, superlative";}
        else if (inputTag.equals("LS")) {return "List item marker";}
        else if (inputTag.equals("MD")) {return "Modal";}
        else if (inputTag.equals("NN")) {return "Noun, singular or mass";}
        else if (inputTag.equals("NNS")) {return "Noun, plural";}
        else if (inputTag.equals("NNP")) {return "Proper noun, singular";}
        else if (inputTag.equals("NNPS")) {return "Proper noun, plural";}
        else if (inputTag.equals("PDT")) {return "Predeterminer";}
        else if (inputTag.equals("POS")) {return "Possessive ending";}
        else if (inputTag.equals("PRP")) {return "Personal pronoun";}
        else if (inputTag.equals("PRP$")) {return "Possessive pronoun";}
        else if (inputTag.equals("RB")) {return "Adverb";}
        else if (inputTag.equals("RBR")) {return "Adverb, comparative";}
        else if (inputTag.equals("RBS")) {return "Adverb, superlative";}
        else if (inputTag.equals("RP")) {return "Particle";}
        else if (inputTag.equals("SYM")) {return "Symbol";}
        else if (inputTag.equals("TO")) {return "to";}
        else if (inputTag.equals("UH")) {return "Interjection";}
        else if (inputTag.equals("VB")) {return "Verb, base form";}
        else if (inputTag.equals("VBD")) {return "Verb, past tense";}
        else if (inputTag.equals("VBG")) {return "Verb, gerund or present participle";}
        else if (inputTag.equals("VBN")) {return "Verb, past participle";}
        else if (inputTag.equals("VBP")) {return "Verb, non­3rd person singular present";}
        else if (inputTag.equals("VBZ")) {return "Verb, 3rd person singular present";}
        else if (inputTag.equals("WDT")) {return "Wh­determiner";}
        else if (inputTag.equals("WP")) {return "Wh­pronoun";}
        else if (inputTag.equals("WP$")) {return "Possessive wh­pronoun";}
        else if (inputTag.equals("WRB")) {return "Wh­adverb";}
        return "no tag match";

    }

   
}
