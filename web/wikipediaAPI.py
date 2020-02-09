import wikipedia

def get_description(company):
    description = 'Wikipedia does not contain a summary for this company.'
    try:
        description = wikipedia.summary(company, sentences=3)
    except:
        description = 'Wikipedia does not contain a summary for this company.'

    return description
