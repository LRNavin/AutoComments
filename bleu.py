import subprocess
import sys


def compute_bleu(ref_file_name, predicted_file_name):
    with open(predicted_file_name) as predicted_file:
        pipe = subprocess.Popen(["perl", "scripts/multi-bleu.perl", ref_file_name], stdin=predicted_file,
                                stdout=sys.stdout, stderr=sys.stderr)
        pipe.communicate()


ref_file = 'outputs/1st_try/test/ref.txt'
pred_file = 'outputs/1st_try/test/pred.txt'

compute_bleu(ref_file, pred_file)
