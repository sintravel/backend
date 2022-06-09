import sys
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

def recommendations(target_place_name, matrix, items, k=5):
    
    recom_idx = matrix.loc[:, target_place_name].values.reshape(1, -1).argsort()[:, ::-1].flatten()[1:k+1]
    recom_id=items.iloc[recom_idx, :].id.values
    recom_category_code = items.iloc[recom_idx, :].category_group_code.values
    d = {'id' : recom_id, 'category_group_code':recom_category_code}
    return pd.DataFrame(d)

if __name__ == "__main__":
    
    placeid=sys.argv[1]
    category=sys.argv[2]
    filtering=sys.argv[3]

    data = pd.read_csv(f'{category}.csv')
    data=data.fillna(" ")
    
    placeidx=data[data['id']==int(placeid)].index
    placename=data.loc[placeidx,'place_name']
    
    if(filtering=='1'):
        idx=data[data['wheelchair']=='n'].index
        data.drop(idx, inplace=True)
    
    tfidf_vector = TfidfVectorizer()
    tfidf_matrix = tfidf_vector.fit_transform(data['place_name'] + " " + data['category_name']+ " "+data['keyword']).toarray()
    tfidf_matrix_feature = tfidf_vector.get_feature_names()
    tfidf_matrix = pd.DataFrame(tfidf_matrix, columns=tfidf_matrix_feature, index = data.place_name)
    cosine_sim = cosine_similarity(tfidf_matrix)
    cosine_sim_df = pd.DataFrame(cosine_sim, index = data.place_name, columns = data.place_name)
    
    df=recommendations(placename, cosine_sim_df, data)
    df.to_csv(f'rcmd{placeid}.csv',index=False)