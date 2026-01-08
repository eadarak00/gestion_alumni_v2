import React, { useState } from 'react';
import { Search, User } from 'lucide-react';

const ListeConversations = ({ conversations, onSelectConversation, activeId }) => {
    const [searchTerm, setSearchTerm] = useState('');

    const filteredConversations = conversations.filter(conv => {
        const participant = conv.participants.find(p => p.id !== 'me');
        return participant?.name.toLowerCase().includes(searchTerm.toLowerCase());
    });

    return (
        <div className="flex flex-col h-full">
            {/* En-tête Sidebar */}
            <div className="p-4 border-b border-gray-100 bg-white sticky top-0 z-10">
                <h2 className="text-xl font-bold text-gray-800 mb-4">Messages</h2>
                <div className="relative">
                    <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-gray-400" />
                    <input
                        type="text"
                        placeholder="Rechercher..."
                        className="w-full pl-9 pr-4 py-2 bg-gray-50 border border-gray-200 rounded-xl text-sm focus:outline-none focus:ring-2 focus:ring-emerald-500/20 focus:border-emerald-500 transition-all"
                        value={searchTerm}
                        onChange={(e) => setSearchTerm(e.target.value)}
                    />
                </div>
            </div>

            {/* Liste Scrollable */}
            <div className="flex-1 overflow-y-auto p-2 scrollbar-thin scrollbar-thumb-gray-200">
                {filteredConversations.length === 0 ? (
                    <div className="text-center md:text-left text-gray-400 text-sm p-4">
                        Aucune conversation trouvée.
                    </div>
                ) : (
                    <div className="space-y-1">
                        {filteredConversations.map((conv) => {
                            const other = conv.participants.find(p => p.id !== 'me');
                            const isActive = conv.id === activeId;

                            return (
                                <button
                                    key={conv.id}
                                    onClick={() => onSelectConversation(conv.id)}
                                    className={`
                    w-full flex items-center gap-3 p-3 rounded-xl transition-all duration-200
                    ${isActive
                                            ? 'bg-emerald-50 shadow-sm border border-emerald-100'
                                            : 'hover:bg-gray-50 border border-transparent'}
                  `}
                                >
                                    <div className="relative">
                                        {other?.avatar ? (
                                            <img
                                                src={other.avatar}
                                                alt={other.name}
                                                className="w-12 h-12 rounded-full object-cover border border-gray-100"
                                            />
                                        ) : (
                                            <div className="w-12 h-12 rounded-full bg-emerald-100 flex items-center justify-center border border-emerald-200">
                                                <User className="w-6 h-6 text-emerald-600" />
                                            </div>
                                        )}
                                        {conv.unreadCount > 0 && (
                                            <span className="absolute -top-1 -right-1 w-5 h-5 bg-red-500 text-white text-xs font-bold rounded-full flex items-center justify-center border-2 border-white">
                                                {conv.unreadCount}
                                            </span>
                                        )}
                                    </div>

                                    <div className="flex-1 min-w-0 text-left">
                                        <div className="flex justify-between items-baseline mb-1">
                                            <span className={`font-semibold truncate ${isActive ? 'text-emerald-900' : 'text-gray-900'}`}>
                                                {other?.name}
                                            </span>
                                            <span className="text-xs text-gray-400 flex-shrink-0 ml-2">
                                                {new Date(conv.lastMessage.timestamp).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}
                                            </span>
                                        </div>
                                        <p className={`text-sm truncate ${conv.unreadCount > 0 ? 'text-gray-900 font-medium' : 'text-gray-500'}`}>
                                            {conv.lastMessage.senderId === 'me' ? 'Vous: ' : ''}{conv.lastMessage.text}
                                        </p>
                                    </div>
                                </button>
                            );
                        })}
                    </div>
                )}
            </div>
        </div>
    );
};

import PropTypes from 'prop-types';

ListeConversations.propTypes = {
    conversations: PropTypes.array.isRequired,
    onSelectConversation: PropTypes.func.isRequired,
    activeId: PropTypes.string,
};

export default ListeConversations;
